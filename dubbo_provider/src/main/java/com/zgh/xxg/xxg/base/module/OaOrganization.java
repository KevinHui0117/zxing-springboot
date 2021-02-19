package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.*;

@Alias(value="OaOrganization")
public class OaOrganization extends BaseEntity implements Serializable,Comparable<OaOrganization>{

	private static final long serialVersionUID = 1L;
	
	public static final String ORGANIZATION_TYPE_LABOURUNION="1"; //工会
	public static final String ORGANIZATION_TYPE_OTHER="2"; //非工会
	
	
	

	private String organizationCode;	//组织编码（自动生成）
	private String organizationName;	//组织名称
	private String organizationStatus;		//状态
	private String organizationType;		//组织类型：1单位，2部门
	private long parentId;		//上级标识
	private String oldOrganizationCode;  //曾经使用过的编码
	private long bigId;  //oa部门所属单位的ID，如果本身就是单位，即为0
    private String systemName;  //内外网类型：1内网办公管理系统，2外网办公管理系统 3,两者均有
	
	//以下信息不存数据库
	private String parentName; //上级名称
	private List<OaLeader> leaders=new ArrayList<OaLeader>();
	private List<OaManager> managers=new ArrayList<OaManager>();
	private List<OaAndOrg> oaAndOrgs=new ArrayList<OaAndOrg>();
    private Integer childNum;           //子节点数量
    private Boolean yesParent=false;           //当前节点是否是父节点
    private Boolean yesMaxNum=false;
    private String oaLeaders;  //新增的oa领导人
    private String oaManagers;  //新增的oa负责人
    private String oaAndOrganizations;   //新增的oa关联的组织机构串
	private String oldLeaders;  //原始的oa领导人
	private String oldManagers;  //原始的oa负责人
	private String oldAndOrganizations;   //原始的oa关联的组织机构串
    private String oaLeadersName;  //oa领导人姓名
    private String oaManagersName;  //oa负责人姓名串
    private String oaAndorgsName;   //oa关联的组织机构名称串

    private int userNumber;  //本组织的人数
    private int allUserNumber;  //本组织及下级组织的人数
    
    private List<OaOrganization> children=new ArrayList<OaOrganization>();
	public List<OaLeader> getLeaders() {
		return leaders;
	}
	public void setLeaders(List<OaLeader> leaders) {
		this.leaders = leaders;
	}
	public List<OaManager> getManagers() {
		return managers;
	}
	public void setManagers(List<OaManager> managers) {
		this.managers = managers;
	}
	public List<OaAndOrg> getOaAndOrgs() {
		return oaAndOrgs;
	}
	public void setOaAndOrgs(List<OaAndOrg> oaAndOrgs) {
		this.oaAndOrgs = oaAndOrgs;
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
	public long getBigId() {
		return bigId;
	}
	public void setBigId(long bigId) {
		this.bigId = bigId;
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

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getOaLeaders() {
        return oaLeaders;
    }

    public void setOaLeaders(String oaLeaders) {
        this.oaLeaders = oaLeaders;
    }

    public String getOaManagers() {
        return oaManagers;
    }

    public void setOaManagers(String oaManagers) {
        this.oaManagers = oaManagers;
    }

    public String getOaAndOrganizations() {
        return oaAndOrganizations;
    }

    public void setOaAndOrganizations(String oaAndOrganizations) {
        this.oaAndOrganizations = oaAndOrganizations;
    }

    public String getOaLeadersName() {
        return oaLeadersName;
    }

    public void setOaLeadersName(String oaLeadersName) {
        this.oaLeadersName = oaLeadersName;
    }

    public String getOaManagersName() {
        return oaManagersName;
    }

    public void setOaManagersName(String oaManagersName) {
        this.oaManagersName = oaManagersName;
    }

    public String getOaAndorgsName() {
        return oaAndorgsName;
    }

    public void setOaAndorgsName(String oaAndorgsName) {
        this.oaAndorgsName = oaAndorgsName;
    }

	public String getOldLeaders() {
		return oldLeaders;
	}

	public void setOldLeaders(String oldLeaders) {
		this.oldLeaders = oldLeaders;
	}

	public String getOldManagers() {
		return oldManagers;
	}

	public void setOldManagers(String oldManagers) {
		this.oldManagers = oldManagers;
	}

	public String getOldAndOrganizations() {
		return oldAndOrganizations;
	}

	public void setOldAndOrganizations(String oldAndOrganizations) {
		this.oldAndOrganizations = oldAndOrganizations;
	}

	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getAllUserNumber() {
		return allUserNumber;
	}
	public void setAllUserNumber(int allUserNumber) {
		this.allUserNumber = allUserNumber;
	}
	public List<OaOrganization> getChildren() {
		return children;
	}
	public void setChildren(List<OaOrganization> children) {
		this.children = children;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof OaOrganization){
			return  this.getId().equals(((OaOrganization) obj).getId());
		}else{
			return false;
		}
	
	}
	
	@Override
	public int compareTo(OaOrganization o) {
		long n=this.getId()-o.getId();
		return (int)n;
	}	
	
	public static List<OaOrganization> toTree(List<OaOrganization> list) {
		OaOrganization root=generateTreeRoot(list);
		return root.getChildren();
    }

	private static  OaOrganization generateTreeRoot(List<OaOrganization> nodeList) {
		OaOrganization root = new OaOrganization();
		if(nodeList==null || nodeList.isEmpty()){
			return root;
		}
		Stack<OaOrganization> stack = new Stack<OaOrganization>();

		while (nodeList.size() > 0) {
			OaOrganization cNode = (OaOrganization) nodeList.get(0);
			nodeList.remove(cNode);
			stack.push(cNode);

			while (cNode != null) {
				cNode = (OaOrganization) stack.pop();
				OaOrganization chNode;
				if ((chNode = getChildren(cNode, nodeList)) != null) {
					stack.push(cNode);
					nodeList.remove(chNode);
					stack.push(chNode);
				} else {
					OaOrganization pNode;
					if (stack.size() > 0) {
						pNode = (OaOrganization) stack.pop();
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

	private static  OaOrganization getChildren(OaOrganization node, List<OaOrganization> list) {
		Iterator<OaOrganization> var3 = list.iterator();

		OaOrganization t;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			t = (OaOrganization) var3.next();
		} while (t.getParentId()==0 || t.getParentId()!=node.getId().longValue());

		return t;
	}

	private static OaOrganization getParent(OaOrganization node, List<OaOrganization> list) {
		Iterator<OaOrganization> var3 = list.iterator();

		OaOrganization t;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			t = (OaOrganization) var3.next();
		} while (t.getId().longValue()!=node.getParentId());

		return t;
	}	
}
