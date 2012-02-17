import sbt._
import sbt.Keys._

object LiftModulesBuildAll extends Build {

	val liftVersion = SettingKey[String]("liftVersion", "The version of the Lift Web Framework")
	
	lazy val googleAnalytics = uri("git://github.com/d6y/liftmodules-googleanalytics.git")
	 	
  	lazy val root = Project(id = "all", base = file(".")).
  					aggregate(googleAnalytics).
  					settings( liftVersion in googleAnalytics := "2.4-M4" )

 
} 