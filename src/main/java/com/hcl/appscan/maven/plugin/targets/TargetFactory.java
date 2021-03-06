/**
 * © Copyright IBM Corporation 2016.
 * © Copyright HCL Technologies Ltd. 2017. 
 * LICENSE: Apache License, Version 2.0 https://www.apache.org/licenses/LICENSE-2.0
 */

package com.hcl.appscan.maven.plugin.targets;

import org.apache.maven.project.MavenProject;

import com.hcl.appscan.maven.plugin.IMavenConstants;
import com.hcl.appscan.sdk.scanners.sast.targets.ISASTTarget;

public class TargetFactory implements IMavenConstants {

	public static ISASTTarget create(MavenProject project) {
		ISASTTarget target;

		switch(project.getPackaging()) {
		case WAR:
		case EAR:
			target = new MavenJEETarget(project);
			break;
		case POM:
			target = null;
			break;
		default:
			target = new MavenJavaTarget(project);
		}
		
		return target;
	}
}
