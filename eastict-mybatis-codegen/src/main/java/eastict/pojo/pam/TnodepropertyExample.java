package eastict.pojo.pam;

import java.util.ArrayList;
import java.util.List;

public class TnodepropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TnodepropertyExample() {
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

        public Criteria andPropertyidIsNull() {
            addCriterion("propertyid is null");
            return (Criteria) this;
        }

        public Criteria andPropertyidIsNotNull() {
            addCriterion("propertyid is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyidEqualTo(Long value) {
            addCriterion("propertyid =", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidNotEqualTo(Long value) {
            addCriterion("propertyid <>", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidGreaterThan(Long value) {
            addCriterion("propertyid >", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidGreaterThanOrEqualTo(Long value) {
            addCriterion("propertyid >=", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidLessThan(Long value) {
            addCriterion("propertyid <", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidLessThanOrEqualTo(Long value) {
            addCriterion("propertyid <=", value, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidIn(List<Long> values) {
            addCriterion("propertyid in", values, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidNotIn(List<Long> values) {
            addCriterion("propertyid not in", values, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidBetween(Long value1, Long value2) {
            addCriterion("propertyid between", value1, value2, "propertyid");
            return (Criteria) this;
        }

        public Criteria andPropertyidNotBetween(Long value1, Long value2) {
            addCriterion("propertyid not between", value1, value2, "propertyid");
            return (Criteria) this;
        }

        public Criteria andNodeidIsNull() {
            addCriterion("nodeid is null");
            return (Criteria) this;
        }

        public Criteria andNodeidIsNotNull() {
            addCriterion("nodeid is not null");
            return (Criteria) this;
        }

        public Criteria andNodeidEqualTo(Long value) {
            addCriterion("nodeid =", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotEqualTo(Long value) {
            addCriterion("nodeid <>", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidGreaterThan(Long value) {
            addCriterion("nodeid >", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidGreaterThanOrEqualTo(Long value) {
            addCriterion("nodeid >=", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidLessThan(Long value) {
            addCriterion("nodeid <", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidLessThanOrEqualTo(Long value) {
            addCriterion("nodeid <=", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidIn(List<Long> values) {
            addCriterion("nodeid in", values, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotIn(List<Long> values) {
            addCriterion("nodeid not in", values, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidBetween(Long value1, Long value2) {
            addCriterion("nodeid between", value1, value2, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotBetween(Long value1, Long value2) {
            addCriterion("nodeid not between", value1, value2, "nodeid");
            return (Criteria) this;
        }

        public Criteria andPropertynameIsNull() {
            addCriterion("propertyname is null");
            return (Criteria) this;
        }

        public Criteria andPropertynameIsNotNull() {
            addCriterion("propertyname is not null");
            return (Criteria) this;
        }

        public Criteria andPropertynameEqualTo(String value) {
            addCriterion("propertyname =", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotEqualTo(String value) {
            addCriterion("propertyname <>", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameGreaterThan(String value) {
            addCriterion("propertyname >", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameGreaterThanOrEqualTo(String value) {
            addCriterion("propertyname >=", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameLessThan(String value) {
            addCriterion("propertyname <", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameLessThanOrEqualTo(String value) {
            addCriterion("propertyname <=", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameLike(String value) {
            addCriterion("propertyname like", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotLike(String value) {
            addCriterion("propertyname not like", value, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameIn(List<String> values) {
            addCriterion("propertyname in", values, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotIn(List<String> values) {
            addCriterion("propertyname not in", values, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameBetween(String value1, String value2) {
            addCriterion("propertyname between", value1, value2, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertynameNotBetween(String value1, String value2) {
            addCriterion("propertyname not between", value1, value2, "propertyname");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueIsNull() {
            addCriterion("propertyvalue is null");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueIsNotNull() {
            addCriterion("propertyvalue is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueEqualTo(String value) {
            addCriterion("propertyvalue =", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueNotEqualTo(String value) {
            addCriterion("propertyvalue <>", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueGreaterThan(String value) {
            addCriterion("propertyvalue >", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueGreaterThanOrEqualTo(String value) {
            addCriterion("propertyvalue >=", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueLessThan(String value) {
            addCriterion("propertyvalue <", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueLessThanOrEqualTo(String value) {
            addCriterion("propertyvalue <=", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueLike(String value) {
            addCriterion("propertyvalue like", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueNotLike(String value) {
            addCriterion("propertyvalue not like", value, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueIn(List<String> values) {
            addCriterion("propertyvalue in", values, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueNotIn(List<String> values) {
            addCriterion("propertyvalue not in", values, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueBetween(String value1, String value2) {
            addCriterion("propertyvalue between", value1, value2, "propertyvalue");
            return (Criteria) this;
        }

        public Criteria andPropertyvalueNotBetween(String value1, String value2) {
            addCriterion("propertyvalue not between", value1, value2, "propertyvalue");
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