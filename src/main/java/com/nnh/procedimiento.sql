CREATE OR REPLACE PROCEDURE public.borraPartitura()
    LANGUAGE plpgsql
    AS $procedure$
        BEGIN
            DELETE FROM nuno WHERE id = 100;
        END;
    $procedure$;