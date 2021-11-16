#!/usr/bin/env bash

if [[ "$#" -ne 1 ]]; then
  echo "Usage: ./`basename "$0"` your-project-name-in-lower-kebab-case"
  exit 1
fi

#PATTERN="^[a-z][a-z0-9]*(-[a-z0-9]+)*$"
#if [[ ! $1 =~ $PATTERN ]]; then
#  echo "Invalid project name: $1"
#  exit 1
#fi

OLD_NAME="boilerplate"
NEW_NAME_KEBAB=$1
NEW_NAME_WITHOUT_DASH=$(echo "$NEW_NAME_KEBAB" | sed "s/-//g")
NEW_NAME_CAMEL=$(echo "$NEW_NAME_KEBAB" | awk -F - '{printf "%s", $1; for(i=2; i<=NF; i++) printf "%s", toupper(substr($i,1,1)) substr($i,2); print"";}')

error() {
  echo "something goes wrong"
  exit 1
}

echo "## rename directories ##"

echo "- for non-kotlin: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type d -name "*$OLD_NAME*" -not -path "*/kotlin/*" | while IFS= read -r ent; do mv -v $ent ${ent%${OLD_NAME}*}${NEW_NAME_KEBAB}${ent##*${OLD_NAME}}; done || error

echo "- for kotlin: $OLD_NAME -> $NEW_NAME_WITHOUT_DASH"
find . -type d -name "*$OLD_NAME*" | while IFS= read -r ent; do mv -v $ent ${ent%${OLD_NAME}*}${NEW_NAME_WITHOUT_DASH}${ent##*${OLD_NAME}}; done || error


echo "## replace text in files ##"

echo "- for DockerfileBatch: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type f -name "DockerfileBatch" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_KEBAB}/g" || error

echo "- for DockerfileCoreApi: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type f -name "DockerfileCoreApi" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_KEBAB}/g" || error

echo "- for entrypointBatch: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type f -name "entrypointBatch.sh" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_KEBAB}/g" || error

echo "- for entrypointCoreApi: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type f -name "entrypointCoreApi.sh" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_KEBAB}/g" || error

echo "- for gradle.properties: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type f -name "gradle.properties" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_WITHOUT_DASH}/g" || error

echo "- for kotlin: $OLD_NAME -> $NEW_NAME_WITHOUT_DASH"
find . -type f -name "*.kt" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_WITHOUT_DASH}/g" || error

echo "- for yml: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type f -name "*.yml" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_KEBAB}/g" || error

echo "- for kts: $OLD_NAME -> $NEW_NAME_KEBAB"
find . -type f -name "*.kts" | xargs sed -i '' "s/${OLD_NAME}/${NEW_NAME_KEBAB}/g" || error

echo "done!"
