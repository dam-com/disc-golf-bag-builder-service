#!/bin/sh

# cut the DATABASE_URL after '@'
export DB_JDBC_URL=jdbc:postgresql://${DATABASE_URL#*@}

# substring the DATABASE_URL between '//' and ':'
export DB_JDBC_USER=$(expr $DATABASE_URL : '.*/\([^:]*\):.*')

# substring the DATABASE_URL between ':' and '@'
export DB_JDBC_PASSWORD=$(expr $DATABASE_URL : '.*:\([^@]*\)@.*')


echo DATABASE_URL=[$DATABASE_URL]
echo DB_JDBC_URL=[$DB_JDBC_URL]
echo DB_JDBC_USER=[$DB_JDBC_USER]
echo DB_JDBC_PASSWORD=[$DB_JDBC_PASSWORD]