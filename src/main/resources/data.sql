--SELECT 1
INSERT INTO THUMBNAIL (path, extension) VALUES
	('http://i.annihil.us/u/prod/marvel/i/mg/a/f0/5202887448860', 'jpg');

INSERT INTO COMIC (available, collection_uri) values
	(217, 'http://gateway.marvel.com/v1/public/characters/1010354/stories');
	
INSERT INTO COMIC_SUMMARY (resource_uri, name, id_comic) VALUES
	('http://gateway.marvel.com/v1/public/comics/17271', 'Annihilation: Conquest (2007) #1', 1),
	('http://gateway.marvel.com/v1/public/comics/17405', 'Annihilation: Conquest (2007) #2', 1),
	('http://gateway.marvel.com/v1/public/comics/17645', 'Annihilation: Conquest (2007) #3', 1);
	
INSERT INTO CHARACTERS (name, description, modified, resourceURI, id_thumbnail, id_comic) VALUES 
	('3-D Man', 'Some random description', '2021-06-16T06:10:16.806164', 'http://gateway.marvel.com/v1/public/characters/1011334', 1, 1),
	('Adam Warlock', 'Adam Warlock is an artificially created human who was born in a cocoon at a scientific complex called The Beehive.', '2021-06-16T06:10:16.806164', 'http://gateway.marvel.com/v1/public/characters/1010354', 1, 1);
