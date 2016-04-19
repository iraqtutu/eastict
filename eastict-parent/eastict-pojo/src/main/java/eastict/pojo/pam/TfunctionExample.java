package eastict.pojo.pam;

import java.util.ArrayList;
import java.util.List;

public class TfunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TfunctionExample() {
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

        public Criteria andFuncidIsNull() {
            addCriterion("funcid is null");
            return (Criteria) this;
        }

        public Criteria andFuncidIsNotNull() {
            addCriterion("funcid is not null");
            return (Criteria) this;
        }

        public Criteria andFuncidEqualTo(Long value) {
            addCriterion("funcid =", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotEqualTo(Long value) {
            addCriterion("funcid <>", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidGreaterThan(Long value) {
            addCriterion("funcid >", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidGreaterThanOrEqualTo(Long value) {
            addCriterion("funcid >=", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidLessThan(Long value) {
            addCriterion("funcid <", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidLessThanOrEqualTo(Long value) {
            addCriterion("funcid <=", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidIn(List<Long> values) {
            addCriterion("funcid in", values, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotIn(List<Long> values) {
            addCriterion("funcid not in", values, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidBetween(Long value1, Long value2) {
            addCriterion("funcid between", value1, value2, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotBetween(Long value1, Long value2) {
            addCriterion("funcid not between", value1, value2, "funcid");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(Long value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(Long value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(Long value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(Long value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(Long value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(Long value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<Long> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<Long> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(Long value1, Long value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(Long value1, Long value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andFunceameIsNull() {
            addCriterion("funceame is null");
            return (Criteria) this;
        }

        public Criteria andFunceameIsNotNull() {
            addCriterion("funceame is not null");
            return (Criteria) this;
        }

        public Criteria andFunceameEqualTo(String value) {
            addCriterion("funceame =", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameNotEqualTo(String value) {
            addCriterion("funceame <>", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameGreaterThan(String value) {
            addCriterion("funceame >", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameGreaterThanOrEqualTo(String value) {
            addCriterion("funceame >=", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameLessThan(String value) {
            addCriterion("funceame <", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameLessThanOrEqualTo(String value) {
            addCriterion("funceame <=", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameLike(String value) {
            addCriterion("funceame like", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameNotLike(String value) {
            addCriterion("funceame not like", value, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameIn(List<String> values) {
            addCriterion("funceame in", values, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameNotIn(List<String> values) {
            addCriterion("funceame not in", values, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameBetween(String value1, String value2) {
            addCriterion("funceame between", value1, value2, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunceameNotBetween(String value1, String value2) {
            addCriterion("funceame not between", value1, value2, "funceame");
            return (Criteria) this;
        }

        public Criteria andFunccnnameIsNull() {
            addCriterion("funccnname is null");
            return (Criteria) this;
        }

        public Criteria andFunccnnameIsNotNull() {
            addCriterion("funccnname is not null");
            return (Criteria) this;
        }

        public Criteria andFunccnnameEqualTo(String value) {
            addCriterion("funccnname =", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameNotEqualTo(String value) {
            addCriterion("funccnname <>", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameGreaterThan(String value) {
            addCriterion("funccnname >", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameGreaterThanOrEqualTo(String value) {
            addCriterion("funccnname >=", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameLessThan(String value) {
            addCriterion("funccnname <", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameLessThanOrEqualTo(String value) {
            addCriterion("funccnname <=", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameLike(String value) {
            addCriterion("funccnname like", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameNotLike(String value) {
            addCriterion("funccnname not like", value, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameIn(List<String> values) {
            addCriterion("funccnname in", values, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameNotIn(List<String> values) {
            addCriterion("funccnname not in", values, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameBetween(String value1, String value2) {
            addCriterion("funccnname between", value1, value2, "funccnname");
            return (Criteria) this;
        }

        public Criteria andFunccnnameNotBetween(String value1, String value2) {
            addCriterion("funccnname not between", value1, value2, "funccnname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIsgroupIsNull() {
            addCriterion("isgroup is null");
            return (Criteria) this;
        }

        public Criteria andIsgroupIsNotNull() {
            addCriterion("isgroup is not null");
            return (Criteria) this;
        }

        public Criteria andIsgroupEqualTo(Boolean value) {
            addCriterion("isgroup =", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupNotEqualTo(Boolean value) {
            addCriterion("isgroup <>", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupGreaterThan(Boolean value) {
            addCriterion("isgroup >", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isgroup >=", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupLessThan(Boolean value) {
            addCriterion("isgroup <", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupLessThanOrEqualTo(Boolean value) {
            addCriterion("isgroup <=", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupIn(List<Boolean> values) {
            addCriterion("isgroup in", values, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupNotIn(List<Boolean> values) {
            addCriterion("isgroup not in", values, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupBetween(Boolean value1, Boolean value2) {
            addCriterion("isgroup between", value1, value2, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isgroup not between", value1, value2, "isgroup");
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