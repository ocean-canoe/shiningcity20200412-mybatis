package com.shiningcity.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class PlatformCatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatformCatalogExample() {
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

        public Criteria andCatalogCodeIsNull() {
            addCriterion("CATALOG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeIsNotNull() {
            addCriterion("CATALOG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeEqualTo(Integer value) {
            addCriterion("CATALOG_CODE =", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeNotEqualTo(Integer value) {
            addCriterion("CATALOG_CODE <>", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeGreaterThan(Integer value) {
            addCriterion("CATALOG_CODE >", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CATALOG_CODE >=", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeLessThan(Integer value) {
            addCriterion("CATALOG_CODE <", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeLessThanOrEqualTo(Integer value) {
            addCriterion("CATALOG_CODE <=", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeIn(List<Integer> values) {
            addCriterion("CATALOG_CODE in", values, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeNotIn(List<Integer> values) {
            addCriterion("CATALOG_CODE not in", values, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeBetween(Integer value1, Integer value2) {
            addCriterion("CATALOG_CODE between", value1, value2, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("CATALOG_CODE not between", value1, value2, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNull() {
            addCriterion("CATALOG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNotNull() {
            addCriterion("CATALOG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameEqualTo(String value) {
            addCriterion("CATALOG_NAME =", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotEqualTo(String value) {
            addCriterion("CATALOG_NAME <>", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThan(String value) {
            addCriterion("CATALOG_NAME >", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("CATALOG_NAME >=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThan(String value) {
            addCriterion("CATALOG_NAME <", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("CATALOG_NAME <=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLike(String value) {
            addCriterion("CATALOG_NAME like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotLike(String value) {
            addCriterion("CATALOG_NAME not like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIn(List<String> values) {
            addCriterion("CATALOG_NAME in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotIn(List<String> values) {
            addCriterion("CATALOG_NAME not in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameBetween(String value1, String value2) {
            addCriterion("CATALOG_NAME between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotBetween(String value1, String value2) {
            addCriterion("CATALOG_NAME not between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeIsNull() {
            addCriterion("PARENT_CATALOG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeIsNotNull() {
            addCriterion("PARENT_CATALOG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeEqualTo(Integer value) {
            addCriterion("PARENT_CATALOG_CODE =", value, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeNotEqualTo(Integer value) {
            addCriterion("PARENT_CATALOG_CODE <>", value, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeGreaterThan(Integer value) {
            addCriterion("PARENT_CATALOG_CODE >", value, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARENT_CATALOG_CODE >=", value, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeLessThan(Integer value) {
            addCriterion("PARENT_CATALOG_CODE <", value, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeLessThanOrEqualTo(Integer value) {
            addCriterion("PARENT_CATALOG_CODE <=", value, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeIn(List<Integer> values) {
            addCriterion("PARENT_CATALOG_CODE in", values, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeNotIn(List<Integer> values) {
            addCriterion("PARENT_CATALOG_CODE not in", values, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_CATALOG_CODE between", value1, value2, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andParentCatalogCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_CATALOG_CODE not between", value1, value2, "parentCatalogCode");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtIsNull() {
            addCriterion("CATALOG_PAHT is null");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtIsNotNull() {
            addCriterion("CATALOG_PAHT is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtEqualTo(String value) {
            addCriterion("CATALOG_PAHT =", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtNotEqualTo(String value) {
            addCriterion("CATALOG_PAHT <>", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtGreaterThan(String value) {
            addCriterion("CATALOG_PAHT >", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtGreaterThanOrEqualTo(String value) {
            addCriterion("CATALOG_PAHT >=", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtLessThan(String value) {
            addCriterion("CATALOG_PAHT <", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtLessThanOrEqualTo(String value) {
            addCriterion("CATALOG_PAHT <=", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtLike(String value) {
            addCriterion("CATALOG_PAHT like", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtNotLike(String value) {
            addCriterion("CATALOG_PAHT not like", value, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtIn(List<String> values) {
            addCriterion("CATALOG_PAHT in", values, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtNotIn(List<String> values) {
            addCriterion("CATALOG_PAHT not in", values, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtBetween(String value1, String value2) {
            addCriterion("CATALOG_PAHT between", value1, value2, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andCatalogPahtNotBetween(String value1, String value2) {
            addCriterion("CATALOG_PAHT not between", value1, value2, "catalogPaht");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("SHOW_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("SHOW_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(Integer value) {
            addCriterion("SHOW_STATUS =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(Integer value) {
            addCriterion("SHOW_STATUS <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(Integer value) {
            addCriterion("SHOW_STATUS >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHOW_STATUS >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(Integer value) {
            addCriterion("SHOW_STATUS <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(Integer value) {
            addCriterion("SHOW_STATUS <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<Integer> values) {
            addCriterion("SHOW_STATUS in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<Integer> values) {
            addCriterion("SHOW_STATUS not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(Integer value1, Integer value2) {
            addCriterion("SHOW_STATUS between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("SHOW_STATUS not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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