
def init_db_query():
    return """
        --create product table
        create table if not exists product
        (
            id uuid not null,
            name character varying(255),
            author_id uuid not null,
            vendor_id uuid,
            price double precision,
            status character varying(255),
            primary key(id),
            constraint uk_product_name unique (id, name)
        
        );
        
        create table if not exists author
        (
            id uuid not null,
            name character varying(255),
            period character varying(255),
            primary key(id),
            constraint  uk_author_name unique (id, name)
        );
        
        alter table product add constraint fk_author foreign key (author_id) references author(id);
        
        create table if not exists vendor
        (
            id uuid not null,
            name character varying(255),
            type character varying(255),
            primary key(id),
            constraint  uk_vendor_name unique (id, name)
        );
        
        alter table product add constraint fk_vendor foreign key (vendor_id) references vendor(id);
    """
