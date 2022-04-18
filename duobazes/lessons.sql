create table categories
(
    categoryid   int auto_increment
        primary key,
    categoryname varchar(15)  not null,
    description  varchar(200) not null
);

create index idx_nc_categoryname
    on categories (categoryname);

create table customers
(
    custid       int auto_increment
        primary key,
    companyname  varchar(40) not null,
    contactname  varchar(30) not null,
    contacttitle varchar(30) not null,
    address      varchar(60) not null,
    city         varchar(15) not null,
    region       varchar(15) null,
    postalcode   varchar(10) null,
    country      varchar(15) not null,
    phone        varchar(24) not null,
    fax          varchar(24) null
);

create index idx_nc_city
    on customers (city);

create index idx_nc_companyname
    on customers (companyname);

create index idx_nc_postalcode
    on customers (postalcode);

create index idx_nc_region
    on customers (region);

create table departments
(
    departmentId int auto_increment
        primary key,
    name         varchar(40) not null
)
    collate = utf8mb3_bin;

create table bitemployees
(
    employee_id  int(10) auto_increment
        primary key,
    FirstName    varchar(50) not null,
    LastName     varchar(50) not null,
    DateOfBirth  date        null,
    phoneNumber  varchar(20) not null,
    email        varchar(40) not null,
    salary       int         not null,
    DepartmentId int         null,
    ManagerId    int         null,
    constraint FK_BITEmployees_DepartmentId
        foreign key (DepartmentId) references departments (departmentId),
    constraint bitemployees_ibfk_1
        foreign key (ManagerId) references bitemployees (employee_id)
)
    collate = utf8mb3_bin;

create index ManagerId
    on bitemployees (ManagerId);

create table drinks
(
    Id   int not null
        primary key,
    Name int null,
    check (`Name` in (1, 2, 3)),
    constraint checkName
        check (`Name` in (1, 2, 3))
);

create table employees
(
    empid           int auto_increment
        primary key,
    lastname        varchar(20) not null,
    firstname       varchar(10) not null,
    title           varchar(30) not null,
    titleofcourtesy varchar(25) not null,
    birthdate       date        not null,
    hiredate        date        not null,
    address         varchar(60) not null,
    city            varchar(15) not null,
    region          varchar(15) null,
    postalcode      varchar(10) null,
    country         varchar(15) not null,
    phone           varchar(24) not null,
    mgrid           int         null,
    constraint FK_Employees_Employees
        foreign key (mgrid) references employees (empid)
);

create index idx_nc_lastname
    on employees (lastname);

create index idx_nc_postalcode
    on employees (postalcode);

create definer = root@localhost trigger Check_employee_birthday_insert
    before insert
    on employees
    for each row
BEGIN
    -- TODO: Move to procedure
    IF (NEW.`birthdate` > SYSDATE()) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Birth day must be less than current date';
    END IF;
END;

create definer = root@localhost trigger Check_employee_birthday_update
    before update
    on employees
    for each row
BEGIN
    -- TODO: Move to procedure
    IF (NEW.`birthdate` > SYSDATE()) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Birth day must be less than current date';
    END IF;
END;

create table friends
(
    Id   int auto_increment
        primary key,
    Name varchar(50) not null,
    City varchar(50) not null
);

create table grandchild
(
    Id          int auto_increment
        primary key,
    ColumnName2 varchar(50) not null,
    ColumnName3 varchar(50) not null,
    constraint AK_ColumnName2
        unique (ColumnName2)
);

create table nums
(
    n int not null
        primary key
);

create table projects
(
    ProjectId   int auto_increment
        primary key,
    Description varchar(50) not null
);

create table employeeproject
(
    EmployeeProjectId int auto_increment
        primary key,
    Employee_Id       int null,
    ProjectId         int null,
    constraint employeeproject_ibfk_1
        foreign key (Employee_Id) references bitemployees (employee_id),
    constraint employeeproject_ibfk_2
        foreign key (ProjectId) references projects (ProjectId)
);

create index Employee_Id
    on employeeproject (Employee_Id);

create index ProjectId
    on employeeproject (ProjectId);

create table sb_airport
(
    biz_id   int auto_increment
        primary key,
    biz_name varchar(50) not null,
    address  varchar(50) not null,
    city     varchar(50) not null
);

create table shippers
(
    shipperid   int auto_increment
        primary key,
    companyname varchar(40) not null,
    phone       varchar(24) not null
);

create table orders
(
    orderid        int auto_increment
        primary key,
    custid         int                         null,
    empid          int                         not null,
    orderdate      date                        not null,
    requireddate   date                        not null,
    shippeddate    date                        null,
    shipperid      int                         not null,
    freight        decimal(10, 2) default 0.00 not null,
    shipname       varchar(40)                 not null,
    shipaddress    varchar(60)                 not null,
    shipcity       varchar(15)                 not null,
    shipregion     varchar(15)                 null,
    shippostalcode varchar(10)                 null,
    shipcountry    varchar(15)                 not null,
    constraint FK_Orders_Customers
        foreign key (custid) references customers (custid),
    constraint FK_Orders_Employees
        foreign key (empid) references employees (empid),
    constraint FK_Orders_Shippers
        foreign key (shipperid) references shippers (shipperid)
);

create index idx_nc_custid
    on orders (custid);

create index idx_nc_empid
    on orders (empid);

create index idx_nc_orderdate
    on orders (orderdate);

create index idx_nc_shippeddate
    on orders (shippeddate);

create index idx_nc_shipperid
    on orders (shipperid);

create index idx_nc_shippostalcode
    on orders (shippostalcode);

create table suppliers
(
    supplierid   int auto_increment
        primary key,
    companyname  varchar(40) not null,
    contactname  varchar(30) not null,
    contacttitle varchar(30) not null,
    address      varchar(60) not null,
    city         varchar(15) not null,
    region       varchar(15) null,
    postalcode   varchar(10) null,
    country      varchar(15) not null,
    phone        varchar(24) not null,
    fax          varchar(24) null
);

create table products
(
    productid    int auto_increment
        primary key,
    productname  varchar(40)                 not null,
    supplierid   int                         not null,
    categoryid   int                         not null,
    unitprice    decimal(10, 2) default 0.00 not null,
    discontinued bit            default b'0' not null,
    constraint FK_Products_Categories
        foreign key (categoryid) references categories (categoryid),
    constraint FK_Products_Suppliers
        foreign key (supplierid) references suppliers (supplierid),
    constraint CHK_Products_unitprice
        check (`unitprice` >= 0)
);

create table orderdetails
(
    orderid   int                          not null,
    productid int                          not null,
    unitprice decimal(10, 2) default 0.00  not null,
    qty       smallint       default 1     not null,
    discount  decimal(4, 3)  default 0.000 not null,
    primary key (orderid, productid),
    constraint FK_OrderDetails_Orders
        foreign key (orderid) references orders (orderid),
    constraint FK_OrderDetails_Products
        foreign key (productid) references products (productid),
    constraint CHK_discount
        check (`discount` between 0 and 1),
    constraint CHK_qty
        check (`qty` > 0),
    constraint CHK_unitprice
        check (`unitprice` >= 0)
);

create index idx_nc_orderid
    on orderdetails (orderid);

create index idx_nc_productid
    on orderdetails (productid);

create index idx_nc_categoryid
    on products (categoryid);

create index idx_nc_productname
    on products (productname);

create index idx_nc_supplierid
    on products (supplierid);

create index idx_nc_companyname
    on suppliers (companyname);

create index idx_nc_postalcode
    on suppliers (postalcode);

create table tablename
(
    Id          int         not null
        primary key,
    ColumnName2 varchar(50) not null,
    ColumnName3 varchar(50) not null
)
    collate = utf8mb3_bin;

create table tests
(
    testid varchar(10) not null
        primary key
);

create table scores
(
    testid    varchar(10) not null,
    studentid varchar(10) not null,
    score     tinyint     not null,
    primary key (testid, studentid),
    constraint FK_Scores_Tests
        foreign key (testid) references tests (testid),
    constraint score
        check (`score` between 0 and 100)
);

create index idx_nc_testid_score
    on scores (testid, score);

create definer = root@localhost view custorders as
select `o`.`custid` AS `custid`, extract(month from `o`.`orderdate`) AS `ordermonth`, sum(`od`.`qty`) AS `qty`
from (`lessons`.`orders` `o`
         join `lessons`.`orderdetails` `od` on (`od`.`orderid` = `o`.`orderid`))
group by `o`.`custid`, extract(month from `o`.`orderdate`);

create definer = root@localhost view emporders as
select `o`.`empid`                                                                        AS `empid`,
       extract(month from `o`.`orderdate`)                                                AS `ordermonth`,
       sum(`od`.`qty`)                                                                    AS `qty`,
       cast(sum(`od`.`qty` * `od`.`unitprice` * (1 - `od`.`discount`)) as decimal(12, 2)) AS `val`,
       count(0)                                                                           AS `numorders`
from (`lessons`.`orders` `o`
         join `lessons`.`orderdetails` `od` on (`od`.`orderid` = `o`.`orderid`))
group by `o`.`empid`, extract(month from `o`.`orderdate`);

create definer = root@localhost view ordertotalsbyyear as
select year(`o`.`orderdate`) AS `orderyear`, sum(`od`.`qty`) AS `qty`
from (`lessons`.`orders` `o`
         join `lessons`.`orderdetails` `od` on (`od`.`orderid` = `o`.`orderid`))
group by year(`o`.`orderdate`);

create definer = root@localhost view ordervalues as
select `o`.`orderid`                                                                      AS `orderid`,
       `o`.`custid`                                                                       AS `custid`,
       `o`.`empid`                                                                        AS `empid`,
       `o`.`shipperid`                                                                    AS `shipperid`,
       `o`.`orderdate`                                                                    AS `orderdate`,
       `o`.`requireddate`                                                                 AS `requireddate`,
       `o`.`shippeddate`                                                                  AS `shippeddate`,
       sum(`od`.`qty`)                                                                    AS `qty`,
       cast(sum(`od`.`qty` * `od`.`unitprice` * (1 - `od`.`discount`)) as decimal(12, 2)) AS `val`
from (`lessons`.`orders` `o`
         join `lessons`.`orderdetails` `od` on (`o`.`orderid` = `od`.`orderid`))
group by `o`.`orderid`, `o`.`custid`, `o`.`empid`, `o`.`shipperid`, `o`.`orderdate`, `o`.`requireddate`,
         `o`.`shippeddate`;

create
    definer = root@localhost procedure GetNums(IN low bigint, IN high bigint)
BEGIN
    PREPARE STMT FROM 'WITH L0 AS (SELECT c FROM (SELECT 1 as c UNION ALL SELECT 1) AS D),
         L1 AS (SELECT 1 AS c
                FROM L0 AS A
                         CROSS JOIN L0 AS B),
         L2 AS (SELECT 1 AS c
                FROM L1 AS A
                         CROSS JOIN L1 AS B),
         L3 AS (SELECT 1 AS c
                FROM L2 AS A
                         CROSS JOIN L2 AS B),
         L4 AS (SELECT 1 AS c
                FROM L3 AS A
                         CROSS JOIN L3 AS B),
         Nums AS (SELECT @i := @i+1 AS rownum FROM L4 AS O, (SELECT @i := 0) AS f)
    SELECT ? + rownum - 1 AS n
    FROM Nums
    ORDER BY rownum LIMIT ?';

    SET @low = low;
    SET @high = high - low + 1;
    EXECUTE STMT USING @low, @high;
END;


