Build all External Lift Modules
===============================

This SBT project aims to build and publish multiple Lift Modules against a specified version of Lift.

The purpose is to be able to change just this build when a new Lift version becomes available, and then this build will compile, package and publish external modules without further intervention. At the same time, individual external Lift modules should still be able to do whatever they want to do on their schedule.

The Plan
---------

* List participating external modules in this build
* Ensure participating external modules use a common SBT `SettingKey` for the liftVersion, so that this build can jump in and change that value.
* Specify the latest Lift version in this build
* Build all participating modules using the version of Lift specified in this build.
* Build via Jenkins and email on error/warning.
* Publish successful builds into the Sonatype repo.

Status
------

* This build is capable of `+publish` multiple modules.

* The Google Analytics module [has been modified](https://github.com/d6y/liftmodules-googleanalytics/commit/8eb5db84b8b2ae346ca437a89449cb0d7478e03b) to be compatible with this (i.e., it uses the `liftVersion` Setting)


TO DO
-----

* Add a regular Lift module and see if that works.

* Decide what to do about PGP signing during build. I guess we have a credentials file on the /private area of the build server and the PGP password in the build file.

* Support non-snapshot builds

Gotchas
-------

* If things go weird, `rm -rf ~/.sbt/staging` (e.g., poms with wrong groupId)



