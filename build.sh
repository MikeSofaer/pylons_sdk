#!/bin/bash
src_dir="/home/unity-android-shim/Desktop/repos/pylons_sdk/src"
lib_dir="/home/unity-android-shim/Desktop/repos/pylons_sdk/lib"
build_dir="/home/unity-android-shim/Desktop/repos/pylons_sdk/build"
interim_build_dir=$build_dir"/java"
rm -rf $build_dir
mkdir $build_dir
mkdir $interim_build_dir
echo "Compiling Unity/Android interop shim"
javac -target 1.7 -source 1.7 -Xlint:unchecked -cp $lib_dir"/*" -d $interim_build_dir $src_dir"/UnityAndroidBridgeActivity.java"
cd $interim_build_dir
jar -cvf $build_dir"/UnityAndroidBridgeActivity.jar" *
#if [ javac -target 1.7 -source 1.7 -Xlint:unchecked -cp lib_dir"/*" -d build_dir"/java" src_dir"/*" ];
#then
#   echo "ok"
#else
#   echo "no"
#fi


#rm -rf /build#
#mkdir /build

#javac -target 1.7 -source 1.7 -Xlint:unchecked -cp /lib/android.jar:/lib/unity.jar -d build/UnityAndroidBridgeActivity.java

#jar -cvf /build/UnityAndroidBridgeActivity.jar *
