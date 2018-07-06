from datetime import datetime, timedelta

import datetime
import time


def getDatetime():
    return datetime.datetime.utcnow()


def stringToDatetime(datetimeString):
    response = datetime.datetime.strptime(datetimeString, "%Y-%m-%d %H:%M:%S.%f")
    return response


def dateToString(dataList):
    months = ["January", "February", "Mars", "April", "May", "June", "July", "August", "September", "October",
              "November", "December"]
    response = dataList[0] + " of " + months[int(dataList[1])] + ", " + dataList[2] + " at " + dataList[3] + "h " + \
               dataList[4] + "m " + dataList[5] + "s "
    return response


def adjustToPeru(hour):
    hour = int(hour)
    if hour >= 5:
        hour -= 5
    else:
        hour = 24 - (5 - hour)
    return str(hour)


def datetimeToList(data):
    dataList = []
    data = str(data).split(" ")

    date = data[0].split("-")
    time = data[1].split(":")
    dataList.append(date[2])
    dataList.append(date[1])
    dataList.append(date[0])

    dataList.append(adjustToPeru(time[0]))
    dataList.append(time[1])
    second = time[2].split(".")
    dataList.append(second[0])

    return dataList


def timeBetweenDatetimes(oldTime, currentTime):
    elapsedTime = currentTime - oldTime

    response = ""

    elapsedTime = str(elapsedTime).replace(", ", ":")
    elapsedTime = str(elapsedTime).split(":")

    second = elapsedTime[-1].split(".")
    elapsedTime[-1] = second[0]

    if len(elapsedTime) == 3:
        names = [" hour", " minute", " second"]
    else:
        days = elapsedTime[0].split(" ")
        elapsedTime[0] = days[0]
        names = [" day", " hour", " minute", " second"]

    for i in range(0, len(names)):
        if int(elapsedTime[i]) != 0:
            response += elapsedTime[i] + names[i]
            if int(elapsedTime[i]) != 1:
                response += "s"
            response += " "
    response += "ago"
    return response


def daysBetweenDatetimes(oldTime, currentTime):
    elapsedTime = stringToDatetime(currentTime) - stringToDatetime(oldTime)
    diff = elapsedTime.days
    response = str(diff) + " days old"
    return response
