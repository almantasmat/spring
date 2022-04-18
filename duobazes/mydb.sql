create table clients
(
    clientId    int         not null
        primary key,
    firstName   varchar(45) not null,
    lastName    varchar(45) not null,
    dateOfBirth date        not null
);

create table movies
(
    movieId           int         not null
        primary key,
    name              varchar(45) not null,
    category          varchar(45) not null,
    durationInMinutes int         not null,
    description       varchar(45) not null
);

create table rooms
(
    roomId   int         not null
        primary key,
    number   int         not null,
    maxSeats int         not null,
    location varchar(45) null
);

create table schedules
(
    scheduleId     int      not null
        primary key,
    startTime      datetime not null,
    movies_movieId int      not null,
    rooms_roomId   int      not null,
    constraint fk_schedules_movies
        foreign key (movies_movieId) references movies (movieId),
    constraint fk_schedules_rooms1
        foreign key (rooms_roomId) references rooms (roomId)
);

create table reservations
(
    reservationId        int not null
        primary key,
    isPaid               int not null,
    clients_clientId     int not null,
    schedules_scheduleId int not null,
    constraint fk_reservations_clients1
        foreign key (clients_clientId) references clients (clientId),
    constraint fk_reservations_schedules1
        foreign key (schedules_scheduleId) references schedules (scheduleId)
);

create index fk_reservations_clients1_idx
    on reservations (clients_clientId);

create index fk_reservations_schedules1_idx
    on reservations (schedules_scheduleId);

create index fk_schedules_movies_idx
    on schedules (movies_movieId);

create index fk_schedules_rooms1_idx
    on schedules (rooms_roomId);

create table seats
(
    seatId       int not null
        primary key,
    row          int not null,
    nuber        int not null,
    rooms_roomId int not null,
    constraint fk_seats_rooms1
        foreign key (rooms_roomId) references rooms (roomId)
);

create table reservation_seat
(
    reservationSeatId          int not null
        primary key,
    reservations_reservationId int not null,
    seats_seatId               int not null,
    constraint fk_reservation_seat_reservations1
        foreign key (reservations_reservationId) references reservations (reservationId),
    constraint fk_reservation_seat_seats1
        foreign key (seats_seatId) references seats (seatId)
);

create index fk_reservation_seat_reservations1_idx
    on reservation_seat (reservations_reservationId);

create index fk_reservation_seat_seats1_idx
    on reservation_seat (seats_seatId);

create index fk_seats_rooms1_idx
    on seats (rooms_roomId);

create table ticketcategories
(
    ticketCategories int         not null
        primary key,
    type             varchar(45) not null,
    price            int         not null
);

create table tickets
(
    ticketId                          int not null
        primary key,
    seats_seatId                      int not null,
    schedules_scheduleId              int not null,
    ticketCategories_ticketCategories int not null,
    constraint fk_tickets_schedules1
        foreign key (schedules_scheduleId) references schedules (scheduleId),
    constraint fk_tickets_seats1
        foreign key (seats_seatId) references seats (seatId),
    constraint fk_tickets_ticketCategories1
        foreign key (ticketCategories_ticketCategories) references ticketcategories (ticketCategories)
);

create index fk_tickets_schedules1_idx
    on tickets (schedules_scheduleId);

create index fk_tickets_seats1_idx
    on tickets (seats_seatId);

create index fk_tickets_ticketCategories1_idx
    on tickets (ticketCategories_ticketCategories);


