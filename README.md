Build all External Lift Modules
===============================

This SBT project aims to build and publish all external Lift Modules against a specified version of Lift.

The purpose is to be able to change just this build when a new Lift version becomes available, and then this build will compile, package and publish external Lift modules without further intervention.

Status
------

* External modules and Lift version is defined in `project/LiftModulesBuildAll.scala`
* The Google Analytics module has been modified to be compatible with this (i.e., it uses the `liftVersion` Setting)
* publish does the right thing, but we have no control over where the output JAR is written.
* Waiting on SBT 0.12 to allow us to set staging directory [implemented by the fix to SSBT issue #331](https://github.com/harrah/xsbt/issues/331)

TO DO
-----

* Support publication
* Support building and publishing SNAPSHOTS
* Set up on Jenkins
* Communicate to Lift mailing list
* Talk to Lift team about triggering build for SNAPSHOT




