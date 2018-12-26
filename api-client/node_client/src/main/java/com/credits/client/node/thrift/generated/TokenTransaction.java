/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.node.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-12-24")
public class TokenTransaction implements org.apache.thrift.TBase<TokenTransaction, TokenTransaction._Fields>, java.io.Serializable, Cloneable, Comparable<TokenTransaction> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TokenTransaction");

  private static final org.apache.thrift.protocol.TField TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("token", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TRANSACTION_FIELD_DESC = new org.apache.thrift.protocol.TField("transaction", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("time", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField INITIATOR_FIELD_DESC = new org.apache.thrift.protocol.TField("initiator", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField METHOD_FIELD_DESC = new org.apache.thrift.protocol.TField("method", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("params", org.apache.thrift.protocol.TType.LIST, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TokenTransactionStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TokenTransactionTupleSchemeFactory();

  public java.nio.ByteBuffer token; // required
  public TransactionId transaction; // required
  public long time; // required
  public java.nio.ByteBuffer initiator; // required
  public java.lang.String method; // required
  public java.util.List<com.credits.general.thrift.generated.Variant> params; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOKEN((short)1, "token"),
    TRANSACTION((short)2, "transaction"),
    TIME((short)3, "time"),
    INITIATOR((short)4, "initiator"),
    METHOD((short)5, "method"),
    PARAMS((short)6, "params");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TOKEN
          return TOKEN;
        case 2: // TRANSACTION
          return TRANSACTION;
        case 3: // TIME
          return TIME;
        case 4: // INITIATOR
          return INITIATOR;
        case 5: // METHOD
          return METHOD;
        case 6: // PARAMS
          return PARAMS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOKEN, new org.apache.thrift.meta_data.FieldMetaData("token", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Address")));
    tmpMap.put(_Fields.TRANSACTION, new org.apache.thrift.meta_data.FieldMetaData("transaction", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TransactionId.class)));
    tmpMap.put(_Fields.TIME, new org.apache.thrift.meta_data.FieldMetaData("time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Time")));
    tmpMap.put(_Fields.INITIATOR, new org.apache.thrift.meta_data.FieldMetaData("initiator", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Address")));
    tmpMap.put(_Fields.METHOD, new org.apache.thrift.meta_data.FieldMetaData("method", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARAMS, new org.apache.thrift.meta_data.FieldMetaData("params", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generated.Variant.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TokenTransaction.class, metaDataMap);
  }

  public TokenTransaction() {
  }

  public TokenTransaction(
    java.nio.ByteBuffer token,
    TransactionId transaction,
    long time,
    java.nio.ByteBuffer initiator,
    java.lang.String method,
    java.util.List<com.credits.general.thrift.generated.Variant> params)
  {
    this();
    this.token = org.apache.thrift.TBaseHelper.copyBinary(token);
    this.transaction = transaction;
    this.time = time;
    setTimeIsSet(true);
    this.initiator = org.apache.thrift.TBaseHelper.copyBinary(initiator);
    this.method = method;
    this.params = params;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TokenTransaction(TokenTransaction other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetToken()) {
      this.token = org.apache.thrift.TBaseHelper.copyBinary(other.token);
    }
    if (other.isSetTransaction()) {
      this.transaction = new TransactionId(other.transaction);
    }
    this.time = other.time;
    if (other.isSetInitiator()) {
      this.initiator = org.apache.thrift.TBaseHelper.copyBinary(other.initiator);
    }
    if (other.isSetMethod()) {
      this.method = other.method;
    }
    if (other.isSetParams()) {
      java.util.List<com.credits.general.thrift.generated.Variant> __this__params = new java.util.ArrayList<com.credits.general.thrift.generated.Variant>(other.params.size());
      for (com.credits.general.thrift.generated.Variant other_element : other.params) {
        __this__params.add(new com.credits.general.thrift.generated.Variant(other_element));
      }
      this.params = __this__params;
    }
  }

  public TokenTransaction deepCopy() {
    return new TokenTransaction(this);
  }

  @Override
  public void clear() {
    this.token = null;
    this.transaction = null;
    setTimeIsSet(false);
    this.time = 0;
    this.initiator = null;
    this.method = null;
    this.params = null;
  }

  public byte[] getToken() {
    setToken(org.apache.thrift.TBaseHelper.rightSize(token));
    return token == null ? null : token.array();
  }

  public java.nio.ByteBuffer bufferForToken() {
    return org.apache.thrift.TBaseHelper.copyBinary(token);
  }

  public TokenTransaction setToken(byte[] token) {
    this.token = token == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(token.clone());
    return this;
  }

  public TokenTransaction setToken(java.nio.ByteBuffer token) {
    this.token = org.apache.thrift.TBaseHelper.copyBinary(token);
    return this;
  }

  public void unsetToken() {
    this.token = null;
  }

  /** Returns true if field token is set (has been assigned a value) and false otherwise */
  public boolean isSetToken() {
    return this.token != null;
  }

  public void setTokenIsSet(boolean value) {
    if (!value) {
      this.token = null;
    }
  }

  public TransactionId getTransaction() {
    return this.transaction;
  }

  public TokenTransaction setTransaction(TransactionId transaction) {
    this.transaction = transaction;
    return this;
  }

  public void unsetTransaction() {
    this.transaction = null;
  }

  /** Returns true if field transaction is set (has been assigned a value) and false otherwise */
  public boolean isSetTransaction() {
    return this.transaction != null;
  }

  public void setTransactionIsSet(boolean value) {
    if (!value) {
      this.transaction = null;
    }
  }

  public long getTime() {
    return this.time;
  }

  public TokenTransaction setTime(long time) {
    this.time = time;
    setTimeIsSet(true);
    return this;
  }

  public void unsetTime() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TIME_ISSET_ID);
  }

  /** Returns true if field time is set (has been assigned a value) and false otherwise */
  public boolean isSetTime() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TIME_ISSET_ID);
  }

  public void setTimeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TIME_ISSET_ID, value);
  }

  public byte[] getInitiator() {
    setInitiator(org.apache.thrift.TBaseHelper.rightSize(initiator));
    return initiator == null ? null : initiator.array();
  }

  public java.nio.ByteBuffer bufferForInitiator() {
    return org.apache.thrift.TBaseHelper.copyBinary(initiator);
  }

  public TokenTransaction setInitiator(byte[] initiator) {
    this.initiator = initiator == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(initiator.clone());
    return this;
  }

  public TokenTransaction setInitiator(java.nio.ByteBuffer initiator) {
    this.initiator = org.apache.thrift.TBaseHelper.copyBinary(initiator);
    return this;
  }

  public void unsetInitiator() {
    this.initiator = null;
  }

  /** Returns true if field initiator is set (has been assigned a value) and false otherwise */
  public boolean isSetInitiator() {
    return this.initiator != null;
  }

  public void setInitiatorIsSet(boolean value) {
    if (!value) {
      this.initiator = null;
    }
  }

  public java.lang.String getMethod() {
    return this.method;
  }

  public TokenTransaction setMethod(java.lang.String method) {
    this.method = method;
    return this;
  }

  public void unsetMethod() {
    this.method = null;
  }

  /** Returns true if field method is set (has been assigned a value) and false otherwise */
  public boolean isSetMethod() {
    return this.method != null;
  }

  public void setMethodIsSet(boolean value) {
    if (!value) {
      this.method = null;
    }
  }

  public int getParamsSize() {
    return (this.params == null) ? 0 : this.params.size();
  }

  public java.util.Iterator<com.credits.general.thrift.generated.Variant> getParamsIterator() {
    return (this.params == null) ? null : this.params.iterator();
  }

  public void addToParams(com.credits.general.thrift.generated.Variant elem) {
    if (this.params == null) {
      this.params = new java.util.ArrayList<com.credits.general.thrift.generated.Variant>();
    }
    this.params.add(elem);
  }

  public java.util.List<com.credits.general.thrift.generated.Variant> getParams() {
    return this.params;
  }

  public TokenTransaction setParams(java.util.List<com.credits.general.thrift.generated.Variant> params) {
    this.params = params;
    return this;
  }

  public void unsetParams() {
    this.params = null;
  }

  /** Returns true if field params is set (has been assigned a value) and false otherwise */
  public boolean isSetParams() {
    return this.params != null;
  }

  public void setParamsIsSet(boolean value) {
    if (!value) {
      this.params = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case TOKEN:
      if (value == null) {
        unsetToken();
      } else {
        if (value instanceof byte[]) {
          setToken((byte[])value);
        } else {
          setToken((java.nio.ByteBuffer)value);
        }
      }
      break;

    case TRANSACTION:
      if (value == null) {
        unsetTransaction();
      } else {
        setTransaction((TransactionId)value);
      }
      break;

    case TIME:
      if (value == null) {
        unsetTime();
      } else {
        setTime((java.lang.Long)value);
      }
      break;

    case INITIATOR:
      if (value == null) {
        unsetInitiator();
      } else {
        if (value instanceof byte[]) {
          setInitiator((byte[])value);
        } else {
          setInitiator((java.nio.ByteBuffer)value);
        }
      }
      break;

    case METHOD:
      if (value == null) {
        unsetMethod();
      } else {
        setMethod((java.lang.String)value);
      }
      break;

    case PARAMS:
      if (value == null) {
        unsetParams();
      } else {
        setParams((java.util.List<com.credits.general.thrift.generated.Variant>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TOKEN:
      return getToken();

    case TRANSACTION:
      return getTransaction();

    case TIME:
      return getTime();

    case INITIATOR:
      return getInitiator();

    case METHOD:
      return getMethod();

    case PARAMS:
      return getParams();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TOKEN:
      return isSetToken();
    case TRANSACTION:
      return isSetTransaction();
    case TIME:
      return isSetTime();
    case INITIATOR:
      return isSetInitiator();
    case METHOD:
      return isSetMethod();
    case PARAMS:
      return isSetParams();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TokenTransaction)
      return this.equals((TokenTransaction)that);
    return false;
  }

  public boolean equals(TokenTransaction that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_token = true && this.isSetToken();
    boolean that_present_token = true && that.isSetToken();
    if (this_present_token || that_present_token) {
      if (!(this_present_token && that_present_token))
        return false;
      if (!this.token.equals(that.token))
        return false;
    }

    boolean this_present_transaction = true && this.isSetTransaction();
    boolean that_present_transaction = true && that.isSetTransaction();
    if (this_present_transaction || that_present_transaction) {
      if (!(this_present_transaction && that_present_transaction))
        return false;
      if (!this.transaction.equals(that.transaction))
        return false;
    }

    boolean this_present_time = true;
    boolean that_present_time = true;
    if (this_present_time || that_present_time) {
      if (!(this_present_time && that_present_time))
        return false;
      if (this.time != that.time)
        return false;
    }

    boolean this_present_initiator = true && this.isSetInitiator();
    boolean that_present_initiator = true && that.isSetInitiator();
    if (this_present_initiator || that_present_initiator) {
      if (!(this_present_initiator && that_present_initiator))
        return false;
      if (!this.initiator.equals(that.initiator))
        return false;
    }

    boolean this_present_method = true && this.isSetMethod();
    boolean that_present_method = true && that.isSetMethod();
    if (this_present_method || that_present_method) {
      if (!(this_present_method && that_present_method))
        return false;
      if (!this.method.equals(that.method))
        return false;
    }

    boolean this_present_params = true && this.isSetParams();
    boolean that_present_params = true && that.isSetParams();
    if (this_present_params || that_present_params) {
      if (!(this_present_params && that_present_params))
        return false;
      if (!this.params.equals(that.params))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetToken()) ? 131071 : 524287);
    if (isSetToken())
      hashCode = hashCode * 8191 + token.hashCode();

    hashCode = hashCode * 8191 + ((isSetTransaction()) ? 131071 : 524287);
    if (isSetTransaction())
      hashCode = hashCode * 8191 + transaction.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(time);

    hashCode = hashCode * 8191 + ((isSetInitiator()) ? 131071 : 524287);
    if (isSetInitiator())
      hashCode = hashCode * 8191 + initiator.hashCode();

    hashCode = hashCode * 8191 + ((isSetMethod()) ? 131071 : 524287);
    if (isSetMethod())
      hashCode = hashCode * 8191 + method.hashCode();

    hashCode = hashCode * 8191 + ((isSetParams()) ? 131071 : 524287);
    if (isSetParams())
      hashCode = hashCode * 8191 + params.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TokenTransaction other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetToken()).compareTo(other.isSetToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.token, other.token);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTransaction()).compareTo(other.isSetTransaction());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTransaction()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.transaction, other.transaction);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTime()).compareTo(other.isSetTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.time, other.time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetInitiator()).compareTo(other.isSetInitiator());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInitiator()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.initiator, other.initiator);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMethod()).compareTo(other.isSetMethod());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMethod()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.method, other.method);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetParams()).compareTo(other.isSetParams());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParams()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.params, other.params);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TokenTransaction(");
    boolean first = true;

    sb.append("token:");
    if (this.token == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.token, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("transaction:");
    if (this.transaction == null) {
      sb.append("null");
    } else {
      sb.append(this.transaction);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("time:");
    sb.append(this.time);
    first = false;
    if (!first) sb.append(", ");
    sb.append("initiator:");
    if (this.initiator == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.initiator, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("method:");
    if (this.method == null) {
      sb.append("null");
    } else {
      sb.append(this.method);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("params:");
    if (this.params == null) {
      sb.append("null");
    } else {
      sb.append(this.params);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (transaction != null) {
      transaction.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TokenTransactionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TokenTransactionStandardScheme getScheme() {
      return new TokenTransactionStandardScheme();
    }
  }

  private static class TokenTransactionStandardScheme extends org.apache.thrift.scheme.StandardScheme<TokenTransaction> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TokenTransaction struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.token = iprot.readBinary();
              struct.setTokenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TRANSACTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.transaction = new TransactionId();
              struct.transaction.read(iprot);
              struct.setTransactionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.time = iprot.readI64();
              struct.setTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // INITIATOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.initiator = iprot.readBinary();
              struct.setInitiatorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // METHOD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.method = iprot.readString();
              struct.setMethodIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list118 = iprot.readListBegin();
                struct.params = new java.util.ArrayList<com.credits.general.thrift.generated.Variant>(_list118.size);
                com.credits.general.thrift.generated.Variant _elem119;
                for (int _i120 = 0; _i120 < _list118.size; ++_i120)
                {
                  _elem119 = new com.credits.general.thrift.generated.Variant();
                  _elem119.read(iprot);
                  struct.params.add(_elem119);
                }
                iprot.readListEnd();
              }
              struct.setParamsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TokenTransaction struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.token != null) {
        oprot.writeFieldBegin(TOKEN_FIELD_DESC);
        oprot.writeBinary(struct.token);
        oprot.writeFieldEnd();
      }
      if (struct.transaction != null) {
        oprot.writeFieldBegin(TRANSACTION_FIELD_DESC);
        struct.transaction.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TIME_FIELD_DESC);
      oprot.writeI64(struct.time);
      oprot.writeFieldEnd();
      if (struct.initiator != null) {
        oprot.writeFieldBegin(INITIATOR_FIELD_DESC);
        oprot.writeBinary(struct.initiator);
        oprot.writeFieldEnd();
      }
      if (struct.method != null) {
        oprot.writeFieldBegin(METHOD_FIELD_DESC);
        oprot.writeString(struct.method);
        oprot.writeFieldEnd();
      }
      if (struct.params != null) {
        oprot.writeFieldBegin(PARAMS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.params.size()));
          for (com.credits.general.thrift.generated.Variant _iter121 : struct.params)
          {
            _iter121.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TokenTransactionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TokenTransactionTupleScheme getScheme() {
      return new TokenTransactionTupleScheme();
    }
  }

  private static class TokenTransactionTupleScheme extends org.apache.thrift.scheme.TupleScheme<TokenTransaction> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TokenTransaction struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetToken()) {
        optionals.set(0);
      }
      if (struct.isSetTransaction()) {
        optionals.set(1);
      }
      if (struct.isSetTime()) {
        optionals.set(2);
      }
      if (struct.isSetInitiator()) {
        optionals.set(3);
      }
      if (struct.isSetMethod()) {
        optionals.set(4);
      }
      if (struct.isSetParams()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetToken()) {
        oprot.writeBinary(struct.token);
      }
      if (struct.isSetTransaction()) {
        struct.transaction.write(oprot);
      }
      if (struct.isSetTime()) {
        oprot.writeI64(struct.time);
      }
      if (struct.isSetInitiator()) {
        oprot.writeBinary(struct.initiator);
      }
      if (struct.isSetMethod()) {
        oprot.writeString(struct.method);
      }
      if (struct.isSetParams()) {
        {
          oprot.writeI32(struct.params.size());
          for (com.credits.general.thrift.generated.Variant _iter122 : struct.params)
          {
            _iter122.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TokenTransaction struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.token = iprot.readBinary();
        struct.setTokenIsSet(true);
      }
      if (incoming.get(1)) {
        struct.transaction = new TransactionId();
        struct.transaction.read(iprot);
        struct.setTransactionIsSet(true);
      }
      if (incoming.get(2)) {
        struct.time = iprot.readI64();
        struct.setTimeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.initiator = iprot.readBinary();
        struct.setInitiatorIsSet(true);
      }
      if (incoming.get(4)) {
        struct.method = iprot.readString();
        struct.setMethodIsSet(true);
      }
      if (incoming.get(5)) {
        {
          org.apache.thrift.protocol.TList _list123 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.params = new java.util.ArrayList<com.credits.general.thrift.generated.Variant>(_list123.size);
          com.credits.general.thrift.generated.Variant _elem124;
          for (int _i125 = 0; _i125 < _list123.size; ++_i125)
          {
            _elem124 = new com.credits.general.thrift.generated.Variant();
            _elem124.read(iprot);
            struct.params.add(_elem124);
          }
        }
        struct.setParamsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

