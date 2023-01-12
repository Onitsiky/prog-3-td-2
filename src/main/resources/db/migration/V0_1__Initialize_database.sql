create table team (
    id   serial,
    name varchar not null unique,
    primary key (id)
);

create table match (
    id          serial,
    datetime    timestamp not null,
    stadium     varchar not null,
    foreigners  int not null unique,
    hosts       int not null unique,
    primary key (id),
    constraint foreigners_fk foreign key (foreigners) references team(id),
    constraint hosts_fk foreign key (hosts) references team(id)
);

create table player (
    id      serial,
    name    varchar not null unique,
    number  int not null,
    team_id int not null,
    primary key (id),
    constraint team_fk foreign key (team_id) references team(id)
);

create table sponsor (
    id      serial,
    name    varchar not null,
    primary key (id)
);

create table have (
    team_id     int,
    sponsor_id  int not null ,
    constraint team_fk foreign key (team_id) references team(id),
    constraint sponsor_fk foreign key (sponsor_id) references sponsor(id)
);