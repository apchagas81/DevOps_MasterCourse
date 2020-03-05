// DLS JOB Content
package javaposse.jobdsl.dsl.helpers

import javaposse.jobdsl.dsl.AbstractExtensibleContext
import javaposse.jobdsl.dsl.ContextHelper
import javaposse.jobdsl.dsl.ContextType
import javaposse.jobdsl.dsl.DslContext
import javaposse.jobdsl.dsl.Item
import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.RequiresPlugin
import javaposse.jobdsl.dsl.helpers.scm.ClearCaseContext
import javaposse.jobdsl.dsl.helpers.scm.GitContext
import javaposse.jobdsl.dsl.helpers.scm.HgContext
import javaposse.jobdsl.dsl.helpers.scm.P4Context

import javaposse.jobdsl.dsl.helpers.scm.RTCContext
import javaposse.jobdsl.dsl.helpers.scm.SvnContext

import static javaposse.jobdsl.dsl.ContextHelper.executeInContext
import static javaposse.jobdsl.dsl.Preconditions.checkArgument
import static javaposse.jobdsl.dsl.Preconditions.checkNotNull
import static javaposse.jobdsl.dsl.Preconditions.checkNotNullOrEmpty
import static javaposse.jobdsl.dsl.Preconditions.checkState
import static javaposse.jobdsl.dsl.helpers.publisher.PublisherContext.VALID_CLONE_WORKSPACE_CRITERIA


job ('First-Maven-Project-Via-DSL') {
	description ("1st Maven Job Generated by DSL on ${new Date()}, the project is a small Mavan project hosted on github")
	scm {
		git("https://github.com/apchagas81/DevOps_MasterCourse.git", 'acme_stg')
	}
	triggers {
		scm('* * * * *')
	}
	steps {
		maven('clean package', 'maven-samples/single-module/pom.xml')
	}
	publishers{
	// archive the generated artifact(
	archiveArtifacts '**/*.jar'
	}


}