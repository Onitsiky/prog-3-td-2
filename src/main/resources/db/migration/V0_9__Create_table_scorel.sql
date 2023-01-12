create table score (
    id serial,
    isOG boolean,
    scoring_time int,
    player_id int,
    match_id int,
    primary key (id),
    constraint scoring_time_constraint check ( scoring_time between 0 and 90),
    constraint player_fk foreign key (player_id) references player(id),
    constraint match_fk foreign key (match_id) references match(id)
);