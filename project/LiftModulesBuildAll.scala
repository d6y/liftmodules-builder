import sbt._
import sbt.Keys._

object LiftModulesBuildAll extends Build {

	val liftVersion = SettingKey[String]("liftVersion", "The version of the Lift Web Framework")
	
	// Git "read-only" URLs appear to be the ones to use here:
	lazy val modules: Seq[ProjectReference] = List(
		uri("git://github.com/d6y/liftmodules-googleanalytics.git"),
		uri("git://github.com/d6y/liftmodules-imap-idle.git") 
	)
	 	
	// Override the version of Lift for all modules being built:
	lazy val moduleSettings = modules.map( module => liftVersion in module := "2.4" )

  	lazy val root = Project(id = "all", base = file(".")).
  					aggregate(modules:_*).
 					settings(publish := { }). // don't publish this wrapper project 
  					settings(moduleSettings:_*)

} 