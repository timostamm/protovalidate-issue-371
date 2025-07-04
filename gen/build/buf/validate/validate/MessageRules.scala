// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO2

package build.buf.validate.validate

/** MessageRules represents validation rules that are applied to the entire message.
  * It includes disabling options and a list of Rule messages representing Common Expression Language (CEL) validation rules.
  *
  * @param disabled
  *   `disabled` is a boolean flag that, when set to true, nullifies any validation rules for this message.
  *   This includes any fields within the message that would otherwise support validation.
  *  
  *   ```proto
  *   message MyMessage {
  *     // validation will be bypassed for this message
  *     option (buf.validate.message).disabled = true;
  *   }
  *   ```
  * @param cel
  *   `cel` is a repeated field of type Rule. Each Rule specifies a validation rule to be applied to this message.
  *   These rules are written in Common Expression Language (CEL) syntax. For more information on
  *   CEL, [see our documentation](https://github.com/bufbuild/protovalidate/blob/main/docs/cel.md).
  *  
  *  
  *   ```proto
  *   message MyMessage {
  *     // The field `foo` must be greater than 42.
  *     option (buf.validate.message).cel = {
  *       id: "my_message.value",
  *       message: "value must be greater than 42",
  *       expression: "this.foo &gt; 42",
  *     };
  *     optional int32 foo = 1;
  *   }
  *   ```
  */
@SerialVersionUID(0L)
final case class MessageRules(
    disabled: _root_.scala.Option[_root_.scala.Boolean] = _root_.scala.None,
    cel: _root_.scala.Seq[build.buf.validate.validate.Rule] = _root_.scala.Seq.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[MessageRules] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      if (disabled.isDefined) {
        val __value = disabled.get
        __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(1, __value)
      };
      cel.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var __size = __serializedSizeMemoized
      if (__size == 0) {
        __size = __computeSerializedSize() + 1
        __serializedSizeMemoized = __size
      }
      __size - 1
      
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      disabled.foreach { __v =>
        val __m = __v
        _output__.writeBool(1, __m)
      };
      cel.foreach { __v =>
        val __m = __v
        _output__.writeTag(3, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def getDisabled: _root_.scala.Boolean = disabled.getOrElse(false)
    def clearDisabled: MessageRules = copy(disabled = _root_.scala.None)
    def withDisabled(__v: _root_.scala.Boolean): MessageRules = copy(disabled = Option(__v))
    def clearCel = copy(cel = _root_.scala.Seq.empty)
    def addCel(__vs: build.buf.validate.validate.Rule *): MessageRules = addAllCel(__vs)
    def addAllCel(__vs: Iterable[build.buf.validate.validate.Rule]): MessageRules = copy(cel = cel ++ __vs)
    def withCel(__v: _root_.scala.Seq[build.buf.validate.validate.Rule]): MessageRules = copy(cel = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => disabled.orNull
        case 3 => cel
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => disabled.map(_root_.scalapb.descriptors.PBoolean(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 3 => _root_.scalapb.descriptors.PRepeated(cel.iterator.map(_.toPMessage).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: build.buf.validate.validate.MessageRules.type = build.buf.validate.validate.MessageRules
    // @@protoc_insertion_point(GeneratedMessage[buf.validate.MessageRules])
}

object MessageRules extends scalapb.GeneratedMessageCompanion[build.buf.validate.validate.MessageRules] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[build.buf.validate.validate.MessageRules] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): build.buf.validate.validate.MessageRules = {
    var __disabled: _root_.scala.Option[_root_.scala.Boolean] = _root_.scala.None
    val __cel: _root_.scala.collection.immutable.VectorBuilder[build.buf.validate.validate.Rule] = new _root_.scala.collection.immutable.VectorBuilder[build.buf.validate.validate.Rule]
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __disabled = _root_.scala.Option(_input__.readBool())
        case 26 =>
          __cel += _root_.scalapb.LiteParser.readMessage[build.buf.validate.validate.Rule](_input__)
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    build.buf.validate.validate.MessageRules(
        disabled = __disabled,
        cel = __cel.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[build.buf.validate.validate.MessageRules] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      build.buf.validate.validate.MessageRules(
        disabled = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[_root_.scala.Boolean]]),
        cel = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Seq[build.buf.validate.validate.Rule]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ValidateProto.javaDescriptor.getMessageTypes().get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ValidateProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 3 => __out = build.buf.validate.validate.Rule
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = build.buf.validate.validate.MessageRules(
    disabled = _root_.scala.None,
    cel = _root_.scala.Seq.empty
  )
  implicit class MessageRulesLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, build.buf.validate.validate.MessageRules]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, build.buf.validate.validate.MessageRules](_l) {
    def disabled: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Boolean] = field(_.getDisabled)((c_, f_) => c_.copy(disabled = _root_.scala.Option(f_)))
    def optionalDisabled: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[_root_.scala.Boolean]] = field(_.disabled)((c_, f_) => c_.copy(disabled = f_))
    def cel: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[build.buf.validate.validate.Rule]] = field(_.cel)((c_, f_) => c_.copy(cel = f_))
  }
  final val DISABLED_FIELD_NUMBER = 1
  final val CEL_FIELD_NUMBER = 3
  def of(
    disabled: _root_.scala.Option[_root_.scala.Boolean],
    cel: _root_.scala.Seq[build.buf.validate.validate.Rule]
  ): _root_.build.buf.validate.validate.MessageRules = _root_.build.buf.validate.validate.MessageRules(
    disabled,
    cel
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[buf.validate.MessageRules])
}
