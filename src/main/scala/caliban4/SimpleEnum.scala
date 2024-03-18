package caliban4

import caliban.GraphQL
import caliban.RootResolver
import caliban.graphQL
import caliban.schema.Schema
import zio.*

import Operations.*

object SimpleEnum extends ZIOAppDefault {

  private val api: GraphQL[Any] = graphQL(
    RootResolver(
      Query(
        enum2String = args => ZIO.succeed(args.select.toString)
      )
    )
  )

  private def quick = {
    import caliban.quick.*
    api
      .runServer(
        port = 8088,
        apiPath = "/api/graphql",
        graphiqlPath = Some("/graphiql")
      )
      .unit
  }

  override def run: ZIO[Any, Throwable, Unit] = Console.printLine(api.render) *> quick
}
