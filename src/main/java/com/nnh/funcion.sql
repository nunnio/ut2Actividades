CREATE OR REPLACE FUNCTION public.cuentaPartituras()
    RETURNS int
    LANGUAGE plpgsql
    AS $$
        declare
        i integer;
        BEGIN
            SELECT COUNT(*) INTO i FROM nuno;
            RETURN i;
        END;
    $$;