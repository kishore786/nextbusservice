# nextbusservice
## Purpose

nextbusservice will get you next bus available in minitutes from a particular stop, route and direction.

---

## Download the tool

Clone the repository:

```bash
git clone https://github.com/kishore786/nextbusservice.git
```

---

## Prerequisites

Download java 8  and maven 3.5 to run locally


---

## How to run it

Run service as:
http://<<IP>>:9002/{route name}/{stop name}/{directrion}

## Example

```
http://54.166.248.173:9002/Brooklyn Ctr - Fremont - 26th Av - Chicago - MOA/7th St  and Olson Memorial Hwy/south

Response:-
{
  "actionResponse": "success",
  "action": "GO",
  "message": "20 Min",
  "status": 200
}
```

---



