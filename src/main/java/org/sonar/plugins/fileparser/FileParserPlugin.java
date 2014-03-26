/*
 * SonarQube File Parser Plugin
 * Copyright (C) 2014 Max Schrimpf
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.fileparser;

import org.sonar.plugins.fileparser.batch.FileParserSensor;
import org.sonar.plugins.fileparser.ui.FileParserWidget;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * This class is the entry point for all extensions
 */
// Properties for an array of Properties
@Properties({
        // the Single Property ( 1 - n )
        @Property(
                // key has to be unique
                key = FileParserPlugin.FOLDER_PATH,
                name = "File Path",
                description = "Specify if you want a special folder to contain the file that shall be displayed",
                defaultValue = "File Parser Plugin",
                global = true,
                project = true,
                module = false),
        @Property(
                // key has to be unique
                key = FileParserPlugin.FILE_NAME,
                name = "File Name",
                description = "Specify if you want a special name for the file to be displayed",
                defaultValue = "File Parser Plugin",
                global = true,
                project = true,
                module = false),
        @Property(
                // key has to be unique
                key = FileParserPlugin.CAPTION,
                name = "File Path Plugin",
                description = "Specify if you want a special caption for the displayed information",
                defaultValue = "File Parser Plugin",
                global = true,
                project = true,
                module = false),

        @Property(
                // key has to be unique
                key = FileParserPlugin.REGEX_STRING,
                name = "Regular Expression",
                description = "Regular Expression to split each line of the file. Only the first two results of the split will be considered",
                defaultValue = "=",
                global = true,
                project = true,
                module = false)
})

public final class FileParserPlugin extends SonarPlugin {

    // modify the following property (variable name, value) to fit your plugin needs
    public static final String FOLDER_PATH = "sonar.fileParser.filePath";
    public static final String FILE_NAME = "sonar.fileParser.fileName";
    public static final String CAPTION = "sonar.fileParser.caption";
    public static final String REGEX_STRING = "sonar.fileParser.regex";

    // This is where you're going to declare all your Sonar extensions
    public List getExtensions() {
        return Arrays.asList(
                // Definitions
                FileParserMetrics.class,

                // Batch
                FileParserSensor.class,

                // UI
                FileParserWidget.class);
    }
}