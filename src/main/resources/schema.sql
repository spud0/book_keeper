-- Book Metadata
create table books (    
    id bigint not null auto_increment primary key,
    isbn varchar(13) not null unique,
    author_name longtext not null,
	publisher_name longtext not null,
    book_title longtext not null, 
    blurb longtext,
    first_published date,
    page_count int not null
);

-- User Metadata
create table users (
    id bigint not null auto_increment primary key, 
    name longtext not null, 
    user_email varchar(255) not null unique,
    user_name varchar(255) not null unique, 
	added_at timestamp default current_timestamp not null,
    passwd longtext not null
);

-- What books belong to what user.
create table user_books (
    id bigint not null auto_increment primary key,
    owner_id bigint not null,
    book_id bigint not null,
    times_read int default 0,
    rating int check (rating >= 0 and rating <= 5),
    notes text,
    added_at timestamp default current_timestamp not null,
    foreign key (owner_id) references users(id),
    foreign key (book_id) references books(id)
);

-- What comments belong to what book
create table comments (
    id bigint not null auto_increment primary key,
    review longtext not null,
    rating int check (rating >= 0 and rating <= 5),
    owner_id bigint not null,
    book_id bigint not null,
    created_at timestamp default current_timestamp not null,
    foreign key (owner_id) references users(id),
    foreign key (book_id) references books(id)
);

