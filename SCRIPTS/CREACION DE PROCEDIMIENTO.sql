USE [TESTING]
GO
/****** Object:  Schema [MANTENIMIENTO_CLIENTE]    Script Date: 25/01/2025 14:16:29 ******/
CREATE SCHEMA [MANTENIMIENTO_CLIENTE]
GO
/****** Object:  Schema [MANTENIMIENTO_TIPO_SEXO]    Script Date: 25/01/2025 14:16:29 ******/
CREATE SCHEMA [MANTENIMIENTO_TIPO_SEXO]
GO
/****** Object:  StoredProcedure [MANTENIMIENTO_CLIENTE].[CONSULTAR]    Script Date: 25/01/2025 14:16:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [MANTENIMIENTO_CLIENTE].[CONSULTAR]
    @Nombre VARCHAR(50),
    @ApellidoPaterno VARCHAR(50),
    @ApellidoMaterno VARCHAR(50),
    @SexoId INT
AS
BEGIN

	 SELECT 
	 cl.CLIENTE_ID, 
	 cl.NOMBRE, 
	 cl.APELLIDO_PATERNO, 
	 cl.APELLIDO_MATERNO, 
	 cl.FECHA_NACIMIENTO, 
	 cl.SEXO_ID, 
	 sx.NOMBRE AS SEXO_STR,
	 cl.DIRECCION, 
	 cl.CORREO
    FROM MAE_CLIENTE cl
	INNER JOIN MAE_SEXO sx on sx.SEXO_ID=cl.SEXO_ID
    WHERE cl.ACTIVO = 1
    AND (@SexoId IS NULL OR @SexoId=cl.SEXO_ID)
    AND (@Nombre IS NULL OR cl.NOMBRE LIKE ('%'+@Nombre+'%') )
    AND (@ApellidoPaterno IS NULL OR cl.APELLIDO_PATERNO LIKE ('%'+@ApellidoPaterno+'%') )
    AND (@ApellidoMaterno IS NULL OR cl.APELLIDO_MATERNO LIKE ('%'+@ApellidoMaterno+'%') );

END;
GO
/****** Object:  StoredProcedure [MANTENIMIENTO_CLIENTE].[ELIMINAR]    Script Date: 25/01/2025 14:16:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [MANTENIMIENTO_CLIENTE].[ELIMINAR]
    @Id INT
AS
BEGIN

	UPDATE MAE_CLIENTE
	SET ACTIVO=0
	WHERE CLIENTE_ID=@Id;

END;
GO
/****** Object:  StoredProcedure [MANTENIMIENTO_CLIENTE].[GUARDAR]    Script Date: 25/01/2025 14:16:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [MANTENIMIENTO_CLIENTE].[GUARDAR]
    @Id INT,
    @Nombre VARCHAR(50),
    @ApellidoPaterno VARCHAR(50),
    @ApellidoMaterno VARCHAR(50),
    @FechaNacimiento DATE,
    @SexoId INT,
    @Direccion VARCHAR(250),
    @Correo VARCHAR(50)
AS
BEGIN

	IF @Id IS NOT NULL AND @Id<>0
	BEGIN
		 UPDATE MAE_CLIENTE
	    SET NOMBRE=@Nombre,
	    APELLIDO_PATERNO=@ApellidoPaterno,
	    APELLIDO_MATERNO=@ApellidoMaterno,
	    FECHA_NACIMIENTO=@FechaNacimiento, 
	    SEXO_ID=@SexoId,
	    DIRECCION=@Direccion,
	    CORREO=@Correo
	    WHERE CLIENTE_ID=@Id;
   END 
   ELSE
   BEGIN
   	INSERT INTO MAE_CLIENTE (NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, FECHA_NACIMIENTO, SEXO_ID, DIRECCION, CORREO)
    	VALUES (@Nombre, @ApellidoPaterno, @ApellidoMaterno, @FechaNacimiento, @SexoId, @Direccion, @Correo);
   END;

END;
GO
/****** Object:  StoredProcedure [MANTENIMIENTO_TIPO_SEXO].[CONSULTAR]    Script Date: 25/01/2025 14:16:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [MANTENIMIENTO_TIPO_SEXO].[CONSULTAR]
AS
BEGIN

	 SELECT 
	 SEXO_ID, 
	 NOMBRE
    FROM MAE_SEXO
    WHERE ACTIVO = 1;

END;

GO
