package caliban4

import caliban.schema.Annotations._
import caliban.schema.ArgBuilder
import caliban.schema.Schema

import Types._

object Types {
  final case class QueryEnum2StringArgs(select: MyEnum)
  object QueryEnum2StringArgs {
    given [R0]: Schema[R0, QueryEnum2StringArgs] = Schema.gen
    given ArgBuilder[QueryEnum2StringArgs]       = ArgBuilder.gen
  }
  sealed trait MyEnum extends scala.Product with scala.Serializable
  object MyEnum {
    @GQLDescription("comment for ENUM1")
    case object ENUM1 extends MyEnum
        derives caliban.schema.Schema.SemiAuto,
          caliban.schema.ArgBuilder
    @GQLDescription("comment for ENUM2")
    case object ENUM2 extends MyEnum
        derives caliban.schema.Schema.SemiAuto,
          caliban.schema.ArgBuilder

    given [R0]: Schema[R0, MyEnum] = Schema.gen
    given ArgBuilder[MyEnum]       = ArgBuilder.gen
  }
}

object Operations {
  final case class Query(
    enum2String: QueryEnum2StringArgs => zio.UIO[String]
  )
  object Query {
    given [R0]: Schema[R0, Query] = Schema.gen
  }
}
