import sbt._
import sbt.Keys._

object LiftModulesBuildAll extends Build {

	val liftVersion = SettingKey[String]("liftVersion", "The version of the Lift Web Framework to build against")
	
	// Git "read-only" URLs appear to be the ones to use here:
	lazy val modules: Seq[ProjectReference] = 
		uri("git://github.com/d6y/liftmodules-googleanalytics.git") ::
		//uri("git://github.com/d6y/liftmodules-imap-idle.git") ::
		Nil
	
	// Override the version of Lift and publish settings for all modules being built:
	lazy val moduleSettings: Seq[Setting[_]] = modules.flatMap { module => List( 
		liftVersion in module := "2.5-SNAPSHOT",
		resolvers in module += ScalaToolsSnapshots,
		publishTo in module := Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"),
		credentials in module += Credentials( file("sonatype.credentials") )
		)
	}

  lazy val all = Project(id = "all", base = file(".")).
  	aggregate(modules:_*).
 		settings(publish := { }). // don't publish this wrapper project 
 		settings(crossScalaVersions := Seq("2.8.1", "2.9.0-1", "2.9.1")).
  	settings(moduleSettings:_*)

}
