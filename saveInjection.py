#!/usr/bin/python
# vamos a montar un script en python que sea una consola
# -*- coding: ascii -*-
import os,sys
import mysql.connector
import argparse

#lee el manual.txt que esta en el directorio raiz del script
def createManFile(self):
    file='manual.txt'
    with open(file,'w+') as reader:
        for line in reader:
            print line
#Este metodo crea los recursos del script
def createResources():
    os.system("touch manual.txt")


#informa de las opciones que hay disponibles
def optionHelp():
    print ("Opciones que se pueden usar:")
    print ("-S [Consulta SQL] esta opcion guarda una sql en base de datos")
    print ("-r La opcion -r lo que hace es crear recursos importantes del sistema")
    print ("-m Esta opcion lo que hace es crear el fichero man.txt con la informacion mas desarrollada")
    print ("l para ver el listado de argumentos que entran en el script")
    print ("")
#muestra la lista de argumentos introducidos
def listArguments():
    print ("Argumentos introducidos:",len(sys.argv))
    print ("Lista de argumentos:", sys.argv)


def sqlSaveIntoDatabase():
    parser = argparse.ArgumentParser()
    parser.add_argument('--name', required=True)
    args =parser.parse_args();
    print (args.name)
    connection_db = mysql.connector.connect(host='localhost', user='',passwd='',db='')
    mysqlSave = connection_db.cursor()
    sql='INSERT INTO saveSql (sql_save) VALUES (%s)'
    var = str(args.name)
    mysqlSave.execute(sql,var)
    mysqlSave.commit()
    mysqlSave.close()

#programa principal del script
if __name__ == '__main__':
    optionHelp()
    opcion = raw_input(">>:")
    while opcion !="q":
        if opcion =="-h":
             #metodo -h
             optionHelp()
        elif opcion=="-S":
             #metodo -S
        elif opcion=="m":
             #metodo m
            createManFile()
        elif opcion=="r":
             #metodo r
            createResources()
        elif opcion=="l":
            #metodo l
            listArguments()
        else:
            #metodo -q
            print 'Goodbye'
            break
        opcion = raw_input(">>:")
