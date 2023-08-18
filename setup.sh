if [ ! -f pom.xml.in ]; then
    echo pom.xml.in not found
    exit 1
fi

# se ja existe
if [ -f pom.xml ]; then
    exit 0
fi

SCRIPT_DIR=$(readlink -f ${BASH_SOURCE[0]} | xargs dirname)
ENV_FILE="$SCRIPT_DIR/.env"

if [ ! -f "$ENV_FILE" ]; then
    echo .env not found
    exit 1
fi

source "$ENV_FILE"

cp pom.xml.in pom.xml
sed -i -e "s/\$MATRICULA/$MATRICULA/g" pom.xml
