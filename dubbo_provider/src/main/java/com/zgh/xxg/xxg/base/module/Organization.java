package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.*;

@Alias(value="Organization")
public class Organization extends BaseEntity implements Serializable,Comparable<Organization>{

	private static final long serialVersionUID = 1L;
	
	public static final String ORGANIZATION_TYPE_LABOURUNION="1"; //工会
	public static final String ORGANIZATION_TYPE_OTHER="2"; //非工会
	
	private String organizationCode;	//组织编码（自动生成）
	private String organizationName;	//组织名称
	private String organizationStatus;		//状态  1正常 0注销
	private String organizationType;		//组织类型：工会ORGANIZATION_TYPE_LABOURUNION  1、业务部门ORGANIZATION_TYPE_OTHER  2
	private long parentId;		//上级标识
	private String oldOrganizationCode;  //曾经使用过的编码
	private long bigId;  //部门所属工会的ID，如果本身就是工会，即为0
	private String labourunionOrgType;  //工会组织类型
	private String cover;  //工会社区覆盖 0否，1覆盖
	private String legalPersonHandle;  //法人办理中 0否，1办理
	private String affiliate;  //隶属关系调整中 1是 0否
	private String logout;		//注销
	private String localunion;		//所属区
	//以下信息不存数据库
	private String parentName;
    private Integer childNum;           //子节点数量
    private Boolean yesParent=false;           //当前节点是否是父节点
    private Boolean yesMaxNum=false;
	private String  labourUnionUnifiedCode;   //工会统一信用代码

	public String getLabourUnionUnifiedCode() {
		return labourUnionUnifiedCode;
	}

	public void setLabourUnionUnifiedCode(String labourUnionUnifiedCode) {
		this.labourUnionUnifiedCode = labourUnionUnifiedCode;
	}

	private List<Organization> children=new ArrayList<Organization>();

	public String getLocalunion() {		return localunion;	}
	public void setLocalunion(String localunion) {		this.localunion = localunion;	}
	public String getLogout() {		return logout;	}
	public void setLogout(String logout) {		this.logout = logout;	}

	public long getBigId() {
		return bigId;
	}
	public void setBigId(long bigId) {
		this.bigId = bigId;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationStatus() {
		return organizationStatus;
	}
	public void setOrganizationStatus(String organizationStatus) {
		this.organizationStatus = organizationStatus;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getOldOrganizationCode() {
		return oldOrganizationCode;
	}
	public void setOldOrganizationCode(String oldOrganizationCode) {
		this.oldOrganizationCode = oldOrganizationCode;
	}

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public Boolean getYesParent() {
        return yesParent;
    }

    public void setYesParent(Boolean yesParent) {
        this.yesParent = yesParent;
    }

    public Boolean getYesMaxNum() {
        return yesMaxNum;
    }

    public void setYesMaxNum(Boolean yesMaxNum) {
        this.yesMaxNum = yesMaxNum;
    }


	public List<Organization> getChildren() {
		return children;
	}
	public void setChildren(List<Organization> children) {
		this.children = children;
	}

	public String getLabourunionOrgType() {		return labourunionOrgType;	}
	public void setLabourunionOrgType(String labourunionOrgType) {		this.labourunionOrgType = labourunionOrgType;	}

	public String getCover() {		return cover;	}
	public void setCover(String cover) {		this.cover = cover;	}

	public String getLegalPersonHandle() {		return legalPersonHandle;	}
	public void setLegalPersonHandle(String legalPersonHandle) {		this.legalPersonHandle = legalPersonHandle;	}

	public String getAffiliate() {		return affiliate;	}
	public void setAffiliate(String affiliate) {		this.affiliate = affiliate;	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof Organization){
			return  this.getId().equals(((Organization) obj).getId());
		}else{
			return false;
		}
	
	}
	
	@Override
	public int compareTo(Organization o) {
		long n=this.getId()-o.getId();
		return (int)n;
	}	
	
	public static List<Organization> toTree(List<Organization> list) {
		Organization root=generateTreeRoot(list);
		return root.getChildren();
    }

	private static Organization generateTreeRoot(List<Organization> nodeList) {
		Organization root = new Organization();
		if(nodeList==null || nodeList.isEmpty()){
			return root;
		}
		Stack<Organization> stack = new Stack<Organization>();

		while (nodeList.size() > 0) {
			Organization cNode = (Organization) nodeList.get(0);
			nodeList.remove(cNode);
			stack.push(cNode);

			while (cNode != null) {
				cNode = (Organization) stack.pop();
				Organization chNode;
				if ((chNode = getChildren(cNode, nodeList)) != null) {
					stack.push(cNode);
					nodeList.remove(chNode);
					stack.push(chNode);
				} else {
					Organization pNode;
					if (stack.size() > 0) {
						pNode = (Organization) stack.pop();
						pNode.getChildren().add(cNode);
						Collections.sort(pNode.getChildren());
						stack.push(pNode);
					} else if ((pNode = getParent(cNode, nodeList)) != null) {
						nodeList.remove(pNode);
						stack.push(pNode);
						pNode.getChildren().add(cNode);
						Collections.sort(pNode.getChildren());
					} else {
						root.getChildren().add(cNode);
						cNode = null;
					}
				}
			}
		}
		Collections.sort(root.getChildren());
		return root;
	}

	private static Organization getChildren(Organization node, List<Organization> list) {
		Iterator<Organization> var3 = list.iterator();

		Organization t;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			t = (Organization) var3.next();
		} while (t.getParentId()==0 || t.getParentId()!=node.getId().longValue());

		return t;
	}

	private static Organization getParent(Organization node, List<Organization> list) {
		Iterator<Organization> var3 = list.iterator();

		Organization t;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			t = (Organization) var3.next();
		} while (t.getId().longValue()!=node.getParentId());

		return t;
	}
	
}
