/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.executor.thrift;

import com.credits.general.thrift.generate.Variant;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-10-08")
public class APIResponse implements org.apache.thrift.TBase<APIResponse, APIResponse._Fields>, java.io.Serializable, Cloneable, Comparable<APIResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("APIResponse");

  private static final org.apache.thrift.protocol.TField CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("code", org.apache.thrift.protocol.TType.BYTE, (short)1);
  private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("message", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CONTRACT_STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("contractState", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField RET_VAL_FIELD_DESC = new org.apache.thrift.protocol.TField("ret_val", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField CONTRACT_VARIABLES_FIELD_DESC = new org.apache.thrift.protocol.TField("contractVariables", org.apache.thrift.protocol.TType.MAP, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new APIResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new APIResponseTupleSchemeFactory();

  public byte code; // required
  public String message; // required
  public java.nio.ByteBuffer contractState; // required
  public Variant ret_val; // optional
  public java.util.Map<String,Variant> contractVariables; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CODE((short)1, "code"),
    MESSAGE((short)2, "message"),
    CONTRACT_STATE((short)3, "contractState"),
    RET_VAL((short)4, "ret_val"),
    CONTRACT_VARIABLES((short)5, "contractVariables");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

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
        case 1: // CODE
          return CODE;
        case 2: // MESSAGE
          return MESSAGE;
        case 3: // CONTRACT_STATE
          return CONTRACT_STATE;
        case 4: // RET_VAL
          return RET_VAL;
        case 5: // CONTRACT_VARIABLES
          return CONTRACT_VARIABLES;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.RET_VAL, _Fields.CONTRACT_VARIABLES};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CODE, new org.apache.thrift.meta_data.FieldMetaData("code", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("message", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONTRACT_STATE, new org.apache.thrift.meta_data.FieldMetaData("contractState", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.RET_VAL, new org.apache.thrift.meta_data.FieldMetaData("ret_val", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generate.Variant.class)));
    tmpMap.put(_Fields.CONTRACT_VARIABLES, new org.apache.thrift.meta_data.FieldMetaData("contractVariables", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP,
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generate.Variant.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(APIResponse.class, metaDataMap);
  }

  public APIResponse() {
  }

  public APIResponse(
    byte code,
    String message,
    java.nio.ByteBuffer contractState)
  {
    this();
    this.code = code;
    setCodeIsSet(true);
    this.message = message;
    this.contractState = org.apache.thrift.TBaseHelper.copyBinary(contractState);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public APIResponse(APIResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    this.code = other.code;
    if (other.isSetMessage()) {
      this.message = other.message;
    }
    if (other.isSetContractState()) {
      this.contractState = org.apache.thrift.TBaseHelper.copyBinary(other.contractState);
    }
    if (other.isSetRet_val()) {
      this.ret_val = new com.credits.general.thrift.generate.Variant(other.ret_val);
    }
    if (other.isSetContractVariables()) {
      java.util.Map<String,com.credits.general.thrift.generate.Variant> __this__contractVariables = new java.util.HashMap<String,com.credits.general.thrift.generate.Variant>(other.contractVariables.size());
      for (java.util.Map.Entry<String, com.credits.general.thrift.generate.Variant> other_element : other.contractVariables.entrySet()) {

        String other_element_key = other_element.getKey();
        com.credits.general.thrift.generate.Variant other_element_value = other_element.getValue();

        String __this__contractVariables_copy_key = other_element_key;

        com.credits.general.thrift.generate.Variant __this__contractVariables_copy_value = new com.credits.general.thrift.generate.Variant(other_element_value);

        __this__contractVariables.put(__this__contractVariables_copy_key, __this__contractVariables_copy_value);
      }
      this.contractVariables = __this__contractVariables;
    }
  }

  public APIResponse deepCopy() {
    return new APIResponse(this);
  }

  @Override
  public void clear() {
    setCodeIsSet(false);
    this.code = 0;
    this.message = null;
    this.contractState = null;
    this.ret_val = null;
    this.contractVariables = null;
  }

  public byte getCode() {
    return this.code;
  }

  public APIResponse setCode(byte code) {
    this.code = code;
    setCodeIsSet(true);
    return this;
  }

  public void unsetCode() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CODE_ISSET_ID);
  }

  /** Returns true if field code is set (has been assigned a value) and false otherwise */
  public boolean isSetCode() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CODE_ISSET_ID);
  }

  public void setCodeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CODE_ISSET_ID, value);
  }

  public String getMessage() {
    return this.message;
  }

  public APIResponse setMessage(String message) {
    this.message = message;
    return this;
  }

  public void unsetMessage() {
    this.message = null;
  }

  /** Returns true if field message is set (has been assigned a value) and false otherwise */
  public boolean isSetMessage() {
    return this.message != null;
  }

  public void setMessageIsSet(boolean value) {
    if (!value) {
      this.message = null;
    }
  }

  public byte[] getContractState() {
    setContractState(org.apache.thrift.TBaseHelper.rightSize(contractState));
    return contractState == null ? null : contractState.array();
  }

  public java.nio.ByteBuffer bufferForContractState() {
    return org.apache.thrift.TBaseHelper.copyBinary(contractState);
  }

  public APIResponse setContractState(byte[] contractState) {
    this.contractState = contractState == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(contractState.clone());
    return this;
  }

  public APIResponse setContractState(java.nio.ByteBuffer contractState) {
    this.contractState = org.apache.thrift.TBaseHelper.copyBinary(contractState);
    return this;
  }

  public void unsetContractState() {
    this.contractState = null;
  }

  /** Returns true if field contractState is set (has been assigned a value) and false otherwise */
  public boolean isSetContractState() {
    return this.contractState != null;
  }

  public void setContractStateIsSet(boolean value) {
    if (!value) {
      this.contractState = null;
    }
  }

  public com.credits.general.thrift.generate.Variant getRet_val() {
    return this.ret_val;
  }

  public APIResponse setRet_val(com.credits.general.thrift.generate.Variant ret_val) {
    this.ret_val = ret_val;
    return this;
  }

  public void unsetRet_val() {
    this.ret_val = null;
  }

  /** Returns true if field ret_val is set (has been assigned a value) and false otherwise */
  public boolean isSetRet_val() {
    return this.ret_val != null;
  }

  public void setRet_valIsSet(boolean value) {
    if (!value) {
      this.ret_val = null;
    }
  }

  public int getContractVariablesSize() {
    return (this.contractVariables == null) ? 0 : this.contractVariables.size();
  }

  public void putToContractVariables(String key, com.credits.general.thrift.generate.Variant val) {
    if (this.contractVariables == null) {
      this.contractVariables = new java.util.HashMap<String,com.credits.general.thrift.generate.Variant>();
    }
    this.contractVariables.put(key, val);
  }

  public java.util.Map<String,com.credits.general.thrift.generate.Variant> getContractVariables() {
    return this.contractVariables;
  }

  public APIResponse setContractVariables(java.util.Map<String,com.credits.general.thrift.generate.Variant> contractVariables) {
    this.contractVariables = contractVariables;
    return this;
  }

  public void unsetContractVariables() {
    this.contractVariables = null;
  }

  /** Returns true if field contractVariables is set (has been assigned a value) and false otherwise */
  public boolean isSetContractVariables() {
    return this.contractVariables != null;
  }

  public void setContractVariablesIsSet(boolean value) {
    if (!value) {
      this.contractVariables = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CODE:
      if (value == null) {
        unsetCode();
      } else {
        setCode((Byte)value);
      }
      break;

    case MESSAGE:
      if (value == null) {
        unsetMessage();
      } else {
        setMessage((String)value);
      }
      break;

    case CONTRACT_STATE:
      if (value == null) {
        unsetContractState();
      } else {
        if (value instanceof byte[]) {
          setContractState((byte[])value);
        } else {
          setContractState((java.nio.ByteBuffer)value);
        }
      }
      break;

    case RET_VAL:
      if (value == null) {
        unsetRet_val();
      } else {
        setRet_val((com.credits.general.thrift.generate.Variant)value);
      }
      break;

    case CONTRACT_VARIABLES:
      if (value == null) {
        unsetContractVariables();
      } else {
        setContractVariables((java.util.Map<String,com.credits.general.thrift.generate.Variant>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CODE:
      return getCode();

    case MESSAGE:
      return getMessage();

    case CONTRACT_STATE:
      return getContractState();

    case RET_VAL:
      return getRet_val();

    case CONTRACT_VARIABLES:
      return getContractVariables();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CODE:
      return isSetCode();
    case MESSAGE:
      return isSetMessage();
    case CONTRACT_STATE:
      return isSetContractState();
    case RET_VAL:
      return isSetRet_val();
    case CONTRACT_VARIABLES:
      return isSetContractVariables();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof APIResponse)
      return this.equals((APIResponse)that);
    return false;
  }

  public boolean equals(APIResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_code = true;
    boolean that_present_code = true;
    if (this_present_code || that_present_code) {
      if (!(this_present_code && that_present_code))
        return false;
      if (this.code != that.code)
        return false;
    }

    boolean this_present_message = true && this.isSetMessage();
    boolean that_present_message = true && that.isSetMessage();
    if (this_present_message || that_present_message) {
      if (!(this_present_message && that_present_message))
        return false;
      if (!this.message.equals(that.message))
        return false;
    }

    boolean this_present_contractState = true && this.isSetContractState();
    boolean that_present_contractState = true && that.isSetContractState();
    if (this_present_contractState || that_present_contractState) {
      if (!(this_present_contractState && that_present_contractState))
        return false;
      if (!this.contractState.equals(that.contractState))
        return false;
    }

    boolean this_present_ret_val = true && this.isSetRet_val();
    boolean that_present_ret_val = true && that.isSetRet_val();
    if (this_present_ret_val || that_present_ret_val) {
      if (!(this_present_ret_val && that_present_ret_val))
        return false;
      if (!this.ret_val.equals(that.ret_val))
        return false;
    }

    boolean this_present_contractVariables = true && this.isSetContractVariables();
    boolean that_present_contractVariables = true && that.isSetContractVariables();
    if (this_present_contractVariables || that_present_contractVariables) {
      if (!(this_present_contractVariables && that_present_contractVariables))
        return false;
      if (!this.contractVariables.equals(that.contractVariables))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + (int) (code);

    hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);
    if (isSetMessage())
      hashCode = hashCode * 8191 + message.hashCode();

    hashCode = hashCode * 8191 + ((isSetContractState()) ? 131071 : 524287);
    if (isSetContractState())
      hashCode = hashCode * 8191 + contractState.hashCode();

    hashCode = hashCode * 8191 + ((isSetRet_val()) ? 131071 : 524287);
    if (isSetRet_val())
      hashCode = hashCode * 8191 + ret_val.hashCode();

    hashCode = hashCode * 8191 + ((isSetContractVariables()) ? 131071 : 524287);
    if (isSetContractVariables())
      hashCode = hashCode * 8191 + contractVariables.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(APIResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCode()).compareTo(other.isSetCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.code, other.code);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessage()).compareTo(other.isSetMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContractState()).compareTo(other.isSetContractState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContractState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contractState, other.contractState);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRet_val()).compareTo(other.isSetRet_val());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRet_val()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ret_val, other.ret_val);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContractVariables()).compareTo(other.isSetContractVariables());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContractVariables()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contractVariables, other.contractVariables);
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
  public String toString() {
    StringBuilder sb = new StringBuilder("APIResponse(");
    boolean first = true;

    sb.append("code:");
    sb.append(this.code);
    first = false;
    if (!first) sb.append(", ");
    sb.append("message:");
    if (this.message == null) {
      sb.append("null");
    } else {
      sb.append(this.message);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("contractState:");
    if (this.contractState == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.contractState, sb);
    }
    first = false;
    if (isSetRet_val()) {
      if (!first) sb.append(", ");
      sb.append("ret_val:");
      if (this.ret_val == null) {
        sb.append("null");
      } else {
        sb.append(this.ret_val);
      }
      first = false;
    }
    if (isSetContractVariables()) {
      if (!first) sb.append(", ");
      sb.append("contractVariables:");
      if (this.contractVariables == null) {
        sb.append("null");
      } else {
        sb.append(this.contractVariables);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class APIResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public APIResponseStandardScheme getScheme() {
      return new APIResponseStandardScheme();
    }
  }

  private static class APIResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<APIResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, APIResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.code = iprot.readByte();
              struct.setCodeIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.message = iprot.readString();
              struct.setMessageIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CONTRACT_STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.contractState = iprot.readBinary();
              struct.setContractStateIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // RET_VAL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.ret_val = new com.credits.general.thrift.generate.Variant();
              struct.ret_val.read(iprot);
              struct.setRet_valIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // CONTRACT_VARIABLES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.contractVariables = new java.util.HashMap<String,com.credits.general.thrift.generate.Variant>(2*_map0.size);
                String _key1;
                com.credits.general.thrift.generate.Variant _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readString();
                  _val2 = new com.credits.general.thrift.generate.Variant();
                  _val2.read(iprot);
                  struct.contractVariables.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setContractVariablesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, APIResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CODE_FIELD_DESC);
      oprot.writeByte(struct.code);
      oprot.writeFieldEnd();
      if (struct.message != null) {
        oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
        oprot.writeString(struct.message);
        oprot.writeFieldEnd();
      }
      if (struct.contractState != null) {
        oprot.writeFieldBegin(CONTRACT_STATE_FIELD_DESC);
        oprot.writeBinary(struct.contractState);
        oprot.writeFieldEnd();
      }
      if (struct.ret_val != null) {
        if (struct.isSetRet_val()) {
          oprot.writeFieldBegin(RET_VAL_FIELD_DESC);
          struct.ret_val.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.contractVariables != null) {
        if (struct.isSetContractVariables()) {
          oprot.writeFieldBegin(CONTRACT_VARIABLES_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.contractVariables.size()));
            for (java.util.Map.Entry<String, com.credits.general.thrift.generate.Variant> _iter4 : struct.contractVariables.entrySet())
            {
              oprot.writeString(_iter4.getKey());
              _iter4.getValue().write(oprot);
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class APIResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public APIResponseTupleScheme getScheme() {
      return new APIResponseTupleScheme();
    }
  }

  private static class APIResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<APIResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, APIResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetCode()) {
        optionals.set(0);
      }
      if (struct.isSetMessage()) {
        optionals.set(1);
      }
      if (struct.isSetContractState()) {
        optionals.set(2);
      }
      if (struct.isSetRet_val()) {
        optionals.set(3);
      }
      if (struct.isSetContractVariables()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetCode()) {
        oprot.writeByte(struct.code);
      }
      if (struct.isSetMessage()) {
        oprot.writeString(struct.message);
      }
      if (struct.isSetContractState()) {
        oprot.writeBinary(struct.contractState);
      }
      if (struct.isSetRet_val()) {
        struct.ret_val.write(oprot);
      }
      if (struct.isSetContractVariables()) {
        {
          oprot.writeI32(struct.contractVariables.size());
          for (java.util.Map.Entry<String, com.credits.general.thrift.generate.Variant> _iter5 : struct.contractVariables.entrySet())
          {
            oprot.writeString(_iter5.getKey());
            _iter5.getValue().write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, APIResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.code = iprot.readByte();
        struct.setCodeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.message = iprot.readString();
        struct.setMessageIsSet(true);
      }
      if (incoming.get(2)) {
        struct.contractState = iprot.readBinary();
        struct.setContractStateIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ret_val = new com.credits.general.thrift.generate.Variant();
        struct.ret_val.read(iprot);
        struct.setRet_valIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TMap _map6 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.contractVariables = new java.util.HashMap<String,com.credits.general.thrift.generate.Variant>(2*_map6.size);
          String _key7;
          com.credits.general.thrift.generate.Variant _val8;
          for (int _i9 = 0; _i9 < _map6.size; ++_i9)
          {
            _key7 = iprot.readString();
            _val8 = new com.credits.general.thrift.generate.Variant();
            _val8.read(iprot);
            struct.contractVariables.put(_key7, _val8);
          }
        }
        struct.setContractVariablesIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

