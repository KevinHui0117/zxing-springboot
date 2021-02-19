package com.zgh.xxg.xxg.base.module;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface IBaseEnum<T extends Serializable> extends IEnum<T> {

}
