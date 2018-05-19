#!/usr/bin/env python3

import sys
import os
import shutil

if __name__ == "__main__":
    shutil.copyfile("./dist/impl.jar", "./gui/lib/impl.jar")
