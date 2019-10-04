# Notes

Below are CRUD API request amd response signatures.
```
GET  http://localhost:8080/note/{userId}

Example : http://localhost:8080/note/al_pacino@usa.com

Response : 200

[
    {
        "id": 1,
        "title": "title",
        "note": "note",
        "createTime": "2019-10-02T13:37:58.000+0000",
        "lastUpdateTime": "2019-10-02T13:37:58.000+0000"
    }
]
Error : 500
```
---------------------------------------------------------------------

```
POST  http://localhost:8080/note/{userId}

Example : http://localhost:8080/note/al_pacino@usa.com

Request :

{
	"title" : "new note title",
	"note" : "new note"
}

Response : 200
{
  "id": 2,
  "title": "new note",
  "note": "hell",
  "createTime": "2019-10-02T13:37:58.000+0000",
  "lastUpdateTime": "2019-10-02T13:37:58.000+0000"
}
Error : 500
```
---------------------------------------------------------------------
```
PUT  http://localhost:8080/note/{userId}

Example : http://localhost:8080/note/al_pacino@usa.com

Request : 

{
	"id" : "2",
	"title" : "updated title",
	"note" : "updated note"
}

Response : 200
{
  "id": 2,
  "title": "updated title",
  "note": "updated note",
  "createTime": "2019-10-02T13:37:58.000+0000",
  "lastUpdateTime": "2019-10-02T13:37:58.000+0000"
}

Error : 500
Message : Note is not present to update

```
---------------------------------------------------------------------
```
DELETE  http://localhost:8080/note/{noteId}/{userId}

Response : 200
true
Error : 500
Message : Not able to delete the note
```
