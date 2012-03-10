Build all External Lift Modules
===============================

This SBT project aims to build and publish all external Lift Modules against a specified version of Lift.

The purpose is to be able to change just this build when a new Lift version becomes available, and then this build will compile, package and publish external Lift modules without further intervention. At the same time, individual external Lift modules should still be able to do whatever they want to do on their schedule.


The Plan
---------

* List participating external modules in this build
* Ensure participating external modules use a common SBT `SettingKey` for the liftVersion, so that this build can jump in and change that value.
* Specify the latest Lift version in this build
* Build all participating modules using the version of Lift specified in this build.
* Build via Jenkins and email on error/warning.
* Publish successful builds into the external modules repo.

Status
------

* External modules and Lift version is defined in `project/LiftModulesBuildAll.scala`
* The Google Analytics module [has been modified](https://github.com/d6y/liftmodules-googleanalytics/commit/8eb5db84b8b2ae346ca437a89449cb0d7478e03b) to be compatible with this (i.e., it uses the `liftVersion` Setting)
* package does the right thing, but we have no control over where the output JAR is written.


TO DO
-----

* Ensure target directory is created on cloudbees for `publish` to avoid "Forbidden" error: https://github.com/harrah/xsbt/issues/323

* Override credentials settings to avoid local dev having to set up credentials in /private/liftmodules/cloudbees.credentials

* Support building and publishing SNAPSHOTS

* Talk to Lift team about triggering build for SNAPSHOT

Gotchas
-------

* If things go weird, `rm -rf ~/.sbt/staging` (e.g., poms with wrong groupId)



