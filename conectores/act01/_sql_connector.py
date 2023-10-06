import sqlite3

DATABASE_NAME = 'ejemplo.db'

# create connection
connection = sqlite3.connect(DATABASE_NAME)

# cursor object
cursor = connection.cursor()

# read data
sql_query = "SELECT * FROM `empleado` "

# check if there is a change in the database
rows = cursor.execute(sql_query).fetchall()

# every row is like a tuple - integer indexed
# if rows will do, since an empty row is `False`
if len(rows) > 0:
    for row in rows:
        id = row[0]
        name = row[1]

        print(
            f"ID: {id} - {name} ")
else:
    print("profile writing to database unsuccessful")

# there is no need to commit here because no changes are made to the database

# close cursor and connection
cursor.close()
connection.close()