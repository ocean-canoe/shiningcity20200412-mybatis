package com.shiningcity.company.pojo;

import java.util.ArrayList;
import java.util.List;

public class BaseCompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseCompanyExample() {
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

        public Criteria andPkidIsNull() {
            addCriterion("PKID is null");
            return (Criteria) this;
        }

        public Criteria andPkidIsNotNull() {
            addCriterion("PKID is not null");
            return (Criteria) this;
        }

        public Criteria andPkidEqualTo(Integer value) {
            addCriterion("PKID =", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotEqualTo(Integer value) {
            addCriterion("PKID <>", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidGreaterThan(Integer value) {
            addCriterion("PKID >", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PKID >=", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidLessThan(Integer value) {
            addCriterion("PKID <", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidLessThanOrEqualTo(Integer value) {
            addCriterion("PKID <=", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidIn(List<Integer> values) {
            addCriterion("PKID in", values, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotIn(List<Integer> values) {
            addCriterion("PKID not in", values, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidBetween(Integer value1, Integer value2) {
            addCriterion("PKID between", value1, value2, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("PKID not between", value1, value2, "pkid");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("COMPANY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("COMPANY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("COMPANY_CODE =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("COMPANY_CODE <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("COMPANY_CODE >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("COMPANY_CODE <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("COMPANY_CODE like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("COMPANY_CODE not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("COMPANY_CODE in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("COMPANY_CODE not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("COMPANY_NAME =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("COMPANY_NAME <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("COMPANY_NAME >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("COMPANY_NAME <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("COMPANY_NAME like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("COMPANY_NAME not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("COMPANY_NAME in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("COMPANY_NAME not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("COMPANY_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("COMPANY_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("COMPANY_ADDRESS >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("COMPANY_ADDRESS <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("COMPANY_ADDRESS like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("COMPANY_ADDRESS not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("COMPANY_ADDRESS in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("COMPANY_ADDRESS not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("COMPANY_ADDRESS between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("COMPANY_ADDRESS not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameIsNull() {
            addCriterion("FIRST_MANAGER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameIsNotNull() {
            addCriterion("FIRST_MANAGER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameEqualTo(String value) {
            addCriterion("FIRST_MANAGER_NAME =", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameNotEqualTo(String value) {
            addCriterion("FIRST_MANAGER_NAME <>", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameGreaterThan(String value) {
            addCriterion("FIRST_MANAGER_NAME >", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_MANAGER_NAME >=", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameLessThan(String value) {
            addCriterion("FIRST_MANAGER_NAME <", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameLessThanOrEqualTo(String value) {
            addCriterion("FIRST_MANAGER_NAME <=", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameLike(String value) {
            addCriterion("FIRST_MANAGER_NAME like", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameNotLike(String value) {
            addCriterion("FIRST_MANAGER_NAME not like", value, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameIn(List<String> values) {
            addCriterion("FIRST_MANAGER_NAME in", values, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameNotIn(List<String> values) {
            addCriterion("FIRST_MANAGER_NAME not in", values, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameBetween(String value1, String value2) {
            addCriterion("FIRST_MANAGER_NAME between", value1, value2, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNameNotBetween(String value1, String value2) {
            addCriterion("FIRST_MANAGER_NAME not between", value1, value2, "firstManagerName");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeIsNull() {
            addCriterion("CERTIFICATE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeIsNotNull() {
            addCriterion("CERTIFICATE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeEqualTo(String value) {
            addCriterion("CERTIFICATE_CODE =", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotEqualTo(String value) {
            addCriterion("CERTIFICATE_CODE <>", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeGreaterThan(String value) {
            addCriterion("CERTIFICATE_CODE >", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_CODE >=", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeLessThan(String value) {
            addCriterion("CERTIFICATE_CODE <", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_CODE <=", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeLike(String value) {
            addCriterion("CERTIFICATE_CODE like", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotLike(String value) {
            addCriterion("CERTIFICATE_CODE not like", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeIn(List<String> values) {
            addCriterion("CERTIFICATE_CODE in", values, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotIn(List<String> values) {
            addCriterion("CERTIFICATE_CODE not in", values, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_CODE between", value1, value2, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_CODE not between", value1, value2, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneIsNull() {
            addCriterion("FIRST_MANAGER_TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneIsNotNull() {
            addCriterion("FIRST_MANAGER_TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneEqualTo(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE =", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneNotEqualTo(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE <>", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneGreaterThan(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE >", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE >=", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneLessThan(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE <", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneLessThanOrEqualTo(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE <=", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneLike(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE like", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneNotLike(String value) {
            addCriterion("FIRST_MANAGER_TELEPHONE not like", value, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneIn(List<String> values) {
            addCriterion("FIRST_MANAGER_TELEPHONE in", values, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneNotIn(List<String> values) {
            addCriterion("FIRST_MANAGER_TELEPHONE not in", values, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneBetween(String value1, String value2) {
            addCriterion("FIRST_MANAGER_TELEPHONE between", value1, value2, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andFirstManagerTelephoneNotBetween(String value1, String value2) {
            addCriterion("FIRST_MANAGER_TELEPHONE not between", value1, value2, "firstManagerTelephone");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIsNull() {
            addCriterion("GROUP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIsNotNull() {
            addCriterion("GROUP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeEqualTo(String value) {
            addCriterion("GROUP_CODE =", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotEqualTo(String value) {
            addCriterion("GROUP_CODE <>", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThan(String value) {
            addCriterion("GROUP_CODE >", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_CODE >=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThan(String value) {
            addCriterion("GROUP_CODE <", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThanOrEqualTo(String value) {
            addCriterion("GROUP_CODE <=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLike(String value) {
            addCriterion("GROUP_CODE like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotLike(String value) {
            addCriterion("GROUP_CODE not like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIn(List<String> values) {
            addCriterion("GROUP_CODE in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotIn(List<String> values) {
            addCriterion("GROUP_CODE not in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeBetween(String value1, String value2) {
            addCriterion("GROUP_CODE between", value1, value2, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotBetween(String value1, String value2) {
            addCriterion("GROUP_CODE not between", value1, value2, "groupCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNull() {
            addCriterion("REGION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("REGION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("REGION_CODE =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("REGION_CODE <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("REGION_CODE >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGION_CODE >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("REGION_CODE <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("REGION_CODE <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("REGION_CODE like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("REGION_CODE not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("REGION_CODE in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("REGION_CODE not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("REGION_CODE between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("REGION_CODE not between", value1, value2, "regionCode");
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