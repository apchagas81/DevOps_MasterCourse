// DLS JOB Content

job ('estapar_MVN') {
	description ("1st Maven Job Generated by DSL on ${new Date()}, the project is a small Mavan project hosted on github")
	scm {
		git("https://github.com/apchagas81/DevOps_MasterCourse.git", 'acme-stg')
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