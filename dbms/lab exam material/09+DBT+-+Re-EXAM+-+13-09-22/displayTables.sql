/*

WRITE A STORED PROCEDURE TO DISPLAY ALL THE TABLES WHOSE NAME STARTS WITH M

*/





DELIMITER &&

CREATE PROCEDURE swm()
BEGIN
    DECLARE tableName VARCHAR(255);
    DECLARE done INT DEFAULT FALSE;
    
    -- Cursor to select table names
    DECLARE tableCursor CURSOR FOR
        SELECT table_name
        FROM information_schema.tables
        WHERE table_schema = DATABASE() AND table_name LIKE 'e%';
    
    -- Declare continue handler to exit loop when no more rows are found
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Open the cursor
    OPEN tableCursor;

    -- Initialize result variable
    SET @tablesStartingWithM = '';

    -- Loop to fetch and concatenate table names
    tableLoop: LOOP
        FETCH tableCursor INTO tableName;
        IF done THEN
            LEAVE tableLoop;
        END IF;

        -- Concatenate table names with a line break
        SET @tablesStartingWithM = CONCAT(@tablesStartingWithM, tableName, '\n');
    END LOOP;

    -- Close the cursor
    CLOSE tableCursor;

    -- Print the result
    SELECT @tablesStartingWithM AS TablesStartingWithM;
END &&

DELIMITER ;