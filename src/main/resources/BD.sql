DROP DATABASE IF EXISTS lumbre;
CREATE DATABASE lumbre;
USE lumbre;

CREATE TABLE empleado(
	id BIGINT NOT NULL auto_increment,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    dni VARCHAR(9) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL UNIQUE,
    passwd VARCHAR(255) NOT NULL,
    --
    CONSTRAINT pk_empleado PRIMARY KEY (id)
);

CREATE TABLE info_contacto(
	id BIGINT NOT NULL auto_increment,
    telefono VARCHAR(25),
    direccion VARCHAR(255),
    poblacion VARCHAR(50),
    cp VARCHAR(10),
    pais VARCHAR(50),
    empleado BIGINT NOT NULL,
    --
    CONSTRAINT pk_contacto PRIMARY KEY (id),
    CONSTRAINT fk_contacto_empleado 
    FOREIGN KEY (empleado) 
    REFERENCES empleado(id)
    ON DELETE CASCADE
);

CREATE TABLE usuario(
	id BIGINT NOT NULL auto_increment,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    passwd VARCHAR(255) NOT NULL,
    --
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE campanha(
	id BIGINT NOT NULL auto_increment,
    titulo VARCHAR(255) NOT NULL,
    resumen VARCHAR(500) NOT NULL,
    informacion TEXT,
    creacion DATE NOT NULL,
    modificacion DATE NOT NULL,
    usuario BIGINT NOT NULL,
    --
    CONSTRAINT pk_campanha PRIMARY KEY (id),
    CONSTRAINT fk_campanha_usuario FOREIGN KEY (usuario) REFERENCES usuario(id)
);

CREATE TABLE raza(
	id BIGINT NOT NULL auto_increment,
    denominacion VARCHAR(255) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    descripcion TEXT,
    usuario BIGINT,
    creacion DATE,
    modificacion DATE,
    --
    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT fk_raza_usuario FOREIGN KEY (usuario) REFERENCES usuario(id)
);

CREATE TABLE sesion(
	id BIGINT NOT NULL auto_increment,
    nombre VARCHAR(255) NOT NULL,
    estado VARCHAR(15),
    planificacion TEXT,
    resultados TEXT,
    fecha DATETIME,
    creacion DATE NOT NULL,
    modificacion DATE NOT NULL,
    campanha_id BIGINT NOT NULL,
    usuario BIGINT NOT NULL,
    --
    CONSTRAINT pk_sesion PRIMARY KEY (id, campanha_id),
    CONSTRAINT fk_sesion_usuario FOREIGN KEY (usuario) REFERENCES usuario(id),
    CONSTRAINT fk_sesion_campanha FOREIGN KEY (campanha_id) REFERENCES campanha(id)
);

CREATE TABLE personaje(
	id BIGINT NOT NULL auto_increment,
    nombre VARCHAR(255) NOT NULL,
    jugador VARCHAR(50),
    informacion TEXT,
    imagen MEDIUMBLOB,
    creacion DATE NOT NULL,
    modificacion DATE NOT NULL,
    usuario BIGINT NOT NULL,
    raza BIGINT NOT NULL,
    --
    CONSTRAINT pk_sesion PRIMARY KEY (id),
    CONSTRAINT fk_personaje_usuario FOREIGN KEY (usuario) REFERENCES usuario(id),
     CONSTRAINT fk_personaje_raza FOREIGN KEY (raza) REFERENCES raza(id)
);

CREATE TABLE personaje_campanha(
	personaje BIGINT NOT NULL,
    campanha BIGINT NOT NULL,
    --
    CONSTRAINT pk_personaje_campanha PRIMARY KEY (personaje,campanha),
    CONSTRAINT fk_personaje_campanha FOREIGN KEY (personaje) REFERENCES personaje(id),
    CONSTRAINT fk_campanha_personaje FOREIGN KEY (campanha) REFERENCES campanha(id)
);

INSERT INTO empleado(nombre,apellidos,dni,email,username,passwd) VALUES(
"Administración",
" ",
"-",
"admin@lumbre.es",
"admin",
-- La contraseña es 'admin'
"$argon2id$v=19$m=1024,t=1,p=1$Z3V0Zi9HSmk0NWx5eGJ4cw$osafLVXNnd/w6vgKprzeA7tjXxbB8DRfl2u8q16nG3Q"
);

INSERT INTO info_contacto(telefono,direccion,poblacion,cp,pais,empleado) VALUES(
"+34600000000","C/ Desarrollo de Aplicaciones Web, 22","Ferrol","15406","España",1
);

INSERT INTO raza(denominacion,tipo,descripcion) VALUES 
("Dracónido","Predefinida","Nacidos de dragones, tal como su nombre proclama, los dracónidos caminan orgullosos por un mundo que los recibe con incomprensión temerosa. Creados por los dioses dracónidos o por los dragones mismos, los dracónidos nacían originalmente de huevos de dragón como una única raza, combinando los mejores atributos de dragones y humanoides. Algunos dracónidos son fieles servidores de verdaderos dragones, otros son soldados que luchan en grandes guerras, y otros se encuentran a la deriva, sin una vocación clara en la vida."),
("Enano","Predefinida","Ricos reinos de antiguas grandezas, salones tallados en las entrañas de las montañas, el eco de picos y martillos en profundas minas y ardientes forjas, la entrega total al clan y la tradición, y un odio visceral hacia los goblins y los orcos. Estos principios comunes unen a todos los enanos."),
("Elfo","Predefinida","Los elfos son un pueblo mágico de gracilidad sobrenatural, que viven en lugares de etérea belleza, morando en el interior de antiguos bosques o en espiras plateadas que brillan con luz feérica, donde una suave música surca el aire y dulces fragancias flotan en el viento. Los elfos aman la naturaleza y la magia, el arte, la música y la poesía."),
("Gnomo","Predefinida","Un murmullo constante de bullicio impregna las madrigueras y vecindarios donde los gnomos forman sus muy unidas comunidades. El murmullo está puntualizado por otros ruidos: un entrechocar de engranajes por allí, una pequeña explosión por allá, un chillido de sorpresa y triunfo, y especialmente estallidos de carcajadas. Los gnomos disfrutan de la vida, recreándose en cada momento de invención, exploración, investigación, creación y diversión."),
("Semielfo","Predefinida","Caminando entre dos mundos pero sin pertenecer a ninguno, los semielfos poseen lo que algunos creen que son las mejores cualidades de sus padres elfos y humanos: la curiosidad, creatividad y ambición de los últimos, templada por los agudos sentidos, amor por la naturaleza y gustos artísticos de los primeros. Algunos semielfos viven entre humanos, apartados por sus diferencias físicas y emocionales, velando por sus amigos y seres queridos mientras el tiempo apenas deja mella en ellos. Otros viven con los elfos, llegando a la madurez mientras sus pares continúan siendo niños, creciendo sin descanso en los eternos reinos élficos. Muchos semielfos, incapaces de encajar en ninguna de estas sociedades, escogen una vida de vagabundeo solitario, o se unen a otros parias e inadaptados en una vida de aventureros."),
("Semiorco","Predefinida","Ya sea unidos bajo el liderazgo de un poderoso brujo o habiendo luchado hasta el hartazgo después de años de conflicto, las tribus orcas y los humanos a veces forman alianzas, uniendo fuerzas en una enorme horda para el terror de las tierras civilizadas de los alrededores. Cuando estas aliazas son selladas mediante matrimonios, nacen los semiorcos. Algunos se alzan para convertirse en orgullosos líderes de sus tribus, aventajándose de su sangre humana frente a sus compañeros de sangre pura. Otros se aventuran al mundo exterior para probarse a sí mismos frente a los humanos y las otras razas civilizadas. Muchos de ellos se convierten en aventureros, cubriéndose de gloria gracias a su fuerza, y de notoriedad por sus costumbres barbáricas y furia salvaje."),
("Mediano","Predefinida","Las comodidades del hogar son la meta en la vida de la mayoría de los medianos: un lugar donde asentarse en paz y tranquilidad, lejos de monstruos acechantes y el choque de ejércitos. Otros forman bandas nómadas que viajan constantemente, atraídos por el camino y el horizonte para descubrir las maravillas de nuevas tierras y sus gentes. Los medianos trabajan de buena gana con otros, y son leales a sus amigos, ya sean medianos o no. Pueden demostrar una ferocidad notable cuando sus amigos, familias o comunidades son amenazadas."),
("Humano","Predefinida","En las crónicas de la mayoría de los mundos, los humanos son la más joven de las razas, tardíos en su llegada a la escena mundial y efímeros en comparación con enanos, elfos y dragones. Quizás es por sus cortas vidas que luchan por lograr tanto como puedan en los años que le son dados; o quizás sienten que tienen algo que probar a las razas mayores, y es ese el por qué de las fundaciones de sus imperios basados en la conquista y el comercio. Cualquiera que sea su motivación, los humanos son los innovadores, los triunfadores y los pioneros de los mundos."),
("Tiflin","Predefinida","Ser recibidos con miradas furtivas y susurros, sufrir violencia e insultos en la calle, ver desconfianza y miedo en cada mirada: ésta es la carga de los tiflin. Además, para empeorar las cosas, los tiflin saben que esto es debido a un pacto realizado hace generaciones que introdujo en sus venas la esencia de Asmodeo, el señor de los Nueve Infiernos. Su apariencia y naturaleza no son culpa suya, sino de un antiguo pecado, por el cual ellos, sus hijos y los hijos de sus hijos siempre deberán pagar el precio.");