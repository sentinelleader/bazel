// Copyright 2015 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.sandbox;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

import java.util.List;

/**
 * Options for sandboxed execution.
 */
public class SandboxOptions extends OptionsBase {

  @Option(
    name = "ignore_unsupported_sandboxing",
    defaultValue = "false",
    category = "strategy",
    help = "Do not print a warning when sandboxed execution is not supported on this system."
  )
  public boolean ignoreUnsupportedSandboxing;

  @Option(
    name = "sandbox_debug",
    defaultValue = "false",
    category = "strategy",
    help =
        "Let the sandbox print debug information on execution. This might help developers of "
            + "Bazel or Skylark rules with debugging failures due to missing input files, etc."
  )
  public boolean sandboxDebug;

  @Option(
    name = "sandbox_add_path",
    allowMultiple = true,
    defaultValue = "",
    category = "config",
    help = "Add additional path to mount to sandbox. Path including workspace is not allowed."
  )
  public List<String> sandboxAddPath;

  @Option(
    name = "sandbox_rootfs",
    category = "config",
    defaultValue = "",
    help = "URL to a tarball (.tar, not .tar.gz or something else) containing the directory to be mounted "
             + "as root inside sandbox instead of the host machine. For example, "
             + "--sandbox_rootfs=http://example.com/path/to/my-image.tar. "
             + "The tarball needs to extract as if the current directory is root. That is, "
             + "if extracted to `/somedir`, `/usr` should be at `/somedir/usr`."
  )
  public String sandboxRootfs;
}
