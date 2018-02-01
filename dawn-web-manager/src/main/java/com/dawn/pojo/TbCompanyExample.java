package com.dawn.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCompanyExample implements Serializable {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TbCompanyExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andCompanyIdIsNull() {
			addCriterion("company_id is null");
			return (Criteria) this;
		}

		public Criteria andCompanyIdIsNotNull() {
			addCriterion("company_id is not null");
			return (Criteria) this;
		}

		public Criteria andCompanyIdEqualTo(Long value) {
			addCriterion("company_id =", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdNotEqualTo(Long value) {
			addCriterion("company_id <>", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdGreaterThan(Long value) {
			addCriterion("company_id >", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
			addCriterion("company_id >=", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdLessThan(Long value) {
			addCriterion("company_id <", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
			addCriterion("company_id <=", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdIn(List<Long> values) {
			addCriterion("company_id in", values, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdNotIn(List<Long> values) {
			addCriterion("company_id not in", values, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdBetween(Long value1, Long value2) {
			addCriterion("company_id between", value1, value2, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
			addCriterion("company_id not between", value1, value2, "companyId");
			return (Criteria) this;
		}

		public Criteria andCorporateIsNull() {
			addCriterion("corporate is null");
			return (Criteria) this;
		}

		public Criteria andCorporateIsNotNull() {
			addCriterion("corporate is not null");
			return (Criteria) this;
		}

		public Criteria andCorporateEqualTo(String value) {
			addCriterion("corporate =", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateNotEqualTo(String value) {
			addCriterion("corporate <>", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateGreaterThan(String value) {
			addCriterion("corporate >", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateGreaterThanOrEqualTo(String value) {
			addCriterion("corporate >=", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateLessThan(String value) {
			addCriterion("corporate <", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateLessThanOrEqualTo(String value) {
			addCriterion("corporate <=", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateLike(String value) {
			addCriterion("corporate like", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateNotLike(String value) {
			addCriterion("corporate not like", value, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateIn(List<String> values) {
			addCriterion("corporate in", values, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateNotIn(List<String> values) {
			addCriterion("corporate not in", values, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateBetween(String value1, String value2) {
			addCriterion("corporate between", value1, value2, "corporate");
			return (Criteria) this;
		}

		public Criteria andCorporateNotBetween(String value1, String value2) {
			addCriterion("corporate not between", value1, value2, "corporate");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andParentidIsNull() {
			addCriterion("parentid is null");
			return (Criteria) this;
		}

		public Criteria andParentidIsNotNull() {
			addCriterion("parentid is not null");
			return (Criteria) this;
		}

		public Criteria andParentidEqualTo(Long value) {
			addCriterion("parentid =", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidNotEqualTo(Long value) {
			addCriterion("parentid <>", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidGreaterThan(Long value) {
			addCriterion("parentid >", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidGreaterThanOrEqualTo(Long value) {
			addCriterion("parentid >=", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidLessThan(Long value) {
			addCriterion("parentid <", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidLessThanOrEqualTo(Long value) {
			addCriterion("parentid <=", value, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidIn(List<Long> values) {
			addCriterion("parentid in", values, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidNotIn(List<Long> values) {
			addCriterion("parentid not in", values, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidBetween(Long value1, Long value2) {
			addCriterion("parentid between", value1, value2, "parentid");
			return (Criteria) this;
		}

		public Criteria andParentidNotBetween(Long value1, Long value2) {
			addCriterion("parentid not between", value1, value2, "parentid");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNull() {
			addCriterion("audit_status is null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNotNull() {
			addCriterion("audit_status is not null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusEqualTo(String value) {
			addCriterion("audit_status =", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotEqualTo(String value) {
			addCriterion("audit_status <>", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThan(String value) {
			addCriterion("audit_status >", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
			addCriterion("audit_status >=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThan(String value) {
			addCriterion("audit_status <", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThanOrEqualTo(String value) {
			addCriterion("audit_status <=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLike(String value) {
			addCriterion("audit_status like", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotLike(String value) {
			addCriterion("audit_status not like", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIn(List<String> values) {
			addCriterion("audit_status in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotIn(List<String> values) {
			addCriterion("audit_status not in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusBetween(String value1, String value2) {
			addCriterion("audit_status between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotBetween(String value1, String value2) {
			addCriterion("audit_status not between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("userid is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userid is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(Integer value) {
			addCriterion("userid =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(Integer value) {
			addCriterion("userid <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(Integer value) {
			addCriterion("userid >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("userid >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(Integer value) {
			addCriterion("userid <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(Integer value) {
			addCriterion("userid <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<Integer> values) {
			addCriterion("userid in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<Integer> values) {
			addCriterion("userid not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(Integer value1, Integer value2) {
			addCriterion("userid between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("userid not between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andCauseIsNull() {
			addCriterion("cause is null");
			return (Criteria) this;
		}

		public Criteria andCauseIsNotNull() {
			addCriterion("cause is not null");
			return (Criteria) this;
		}

		public Criteria andCauseEqualTo(String value) {
			addCriterion("cause =", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotEqualTo(String value) {
			addCriterion("cause <>", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseGreaterThan(String value) {
			addCriterion("cause >", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseGreaterThanOrEqualTo(String value) {
			addCriterion("cause >=", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseLessThan(String value) {
			addCriterion("cause <", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseLessThanOrEqualTo(String value) {
			addCriterion("cause <=", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseLike(String value) {
			addCriterion("cause like", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotLike(String value) {
			addCriterion("cause not like", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseIn(List<String> values) {
			addCriterion("cause in", values, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotIn(List<String> values) {
			addCriterion("cause not in", values, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseBetween(String value1, String value2) {
			addCriterion("cause between", value1, value2, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotBetween(String value1, String value2) {
			addCriterion("cause not between", value1, value2, "cause");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNull() {
			addCriterion("user_type is null");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNotNull() {
			addCriterion("user_type is not null");
			return (Criteria) this;
		}

		public Criteria andUserTypeEqualTo(Integer value) {
			addCriterion("user_type =", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotEqualTo(Integer value) {
			addCriterion("user_type <>", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThan(Integer value) {
			addCriterion("user_type >", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_type >=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThan(Integer value) {
			addCriterion("user_type <", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
			addCriterion("user_type <=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeIn(List<Integer> values) {
			addCriterion("user_type in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotIn(List<Integer> values) {
			addCriterion("user_type not in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeBetween(Integer value1, Integer value2) {
			addCriterion("user_type between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("user_type not between", value1, value2, "userType");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}