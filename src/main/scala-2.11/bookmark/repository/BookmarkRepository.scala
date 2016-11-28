package bookmark.repository

import bookmark.DatabaseConfig
import bookmark.model.Bookmark

/**
  * Created by yw on 16. 11. 28.
  */
trait BookmarkRepository extends DatabaseConfig {

  import driver.api._

  protected val bookmarks = TableQuery[Bookmarks]

  class Bookmarks(tag: Tag) extends Table[Bookmark](tag, "bookmark") {
    def * = (id, title, url, content) <> ((Bookmark.apply _).tupled, Bookmark.unapply)

    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)

    def title = column[String]("title")

    def url = column[String]("url")

    def content = column[String]("content")
  }

}
