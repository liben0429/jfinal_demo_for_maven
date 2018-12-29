package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUcUser<M extends BaseUcUser<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setNickName(java.lang.String nickName) {
		set("nick_name", nickName);
	}
	
	public java.lang.String getNickName() {
		return getStr("nick_name");
	}

	public void setUserName(java.lang.String userName) {
		set("user_name", userName);
	}
	
	public java.lang.String getUserName() {
		return getStr("user_name");
	}

	public void setPassWord(java.lang.String passWord) {
		set("pass_word", passWord);
	}
	
	public java.lang.String getPassWord() {
		return getStr("pass_word");
	}

	public void setDeleted(java.lang.Boolean deleted) {
		set("deleted", deleted);
	}
	
	public java.lang.Boolean getDeleted() {
		return get("deleted");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}
	
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}
