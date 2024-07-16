USE [BookStore]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 7/16/2024 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[bill_id] [int] IDENTITY(1,1) NOT NULL,
	[bill_date] [datetime] NULL,
	[customer_name] [nvarchar](50) NULL,
	[user_id] [int] NULL,
	[total] [int] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK_Bill] PRIMARY KEY CLUSTERED 
(
	[bill_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillDetails]    Script Date: 7/16/2024 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillDetails](
	[id_bill_details] [int] IDENTITY(1,1) NOT NULL,
	[book_id] [int] NULL,
	[book_price] [int] NULL,
	[amount] [int] NULL,
	[bill_id] [int] NULL,
 CONSTRAINT [PK_BillDetails] PRIMARY KEY CLUSTERED 
(
	[id_bill_details] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Books]    Script Date: 7/16/2024 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[book_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](250) NULL,
	[image] [nvarchar](max) NULL,
	[quantity] [int] NULL,
	[author] [nvarchar](50) NULL,
	[date_of_public] [datetime] NULL,
	[price] [int] NULL,
	[publisher] [nvarchar](50) NULL,
	[description] [nvarchar](max) NULL,
	[category] [int] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK_Books] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 7/16/2024 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 7/16/2024 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[full_name] [nvarchar](50) NULL,
	[rollNumber] [nvarchar](150) NULL,
	[phone] [nvarchar](50) NULL,
	[role] [int] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([bill_id], [bill_date], [customer_name], [user_id], [total], [status]) VALUES (5, CAST(N'2024-07-07T14:54:07.910' AS DateTime), N'customer1', 0, 311700, 2)
INSERT [dbo].[Bill] ([bill_id], [bill_date], [customer_name], [user_id], [total], [status]) VALUES (6, CAST(N'2024-07-07T14:54:44.360' AS DateTime), N'customer2', 0, 66300, 1)
INSERT [dbo].[Bill] ([bill_id], [bill_date], [customer_name], [user_id], [total], [status]) VALUES (7, CAST(N'2024-07-07T14:56:06.373' AS DateTime), N'customer3', 0, 66300, 1)
INSERT [dbo].[Bill] ([bill_id], [bill_date], [customer_name], [user_id], [total], [status]) VALUES (8, CAST(N'2024-07-07T14:58:32.437' AS DateTime), N'customer4', 0, 153300, 1)
INSERT [dbo].[Bill] ([bill_id], [bill_date], [customer_name], [user_id], [total], [status]) VALUES (9, CAST(N'2024-07-07T15:23:02.640' AS DateTime), N'customer5', 0, 0, 1)
INSERT [dbo].[Bill] ([bill_id], [bill_date], [customer_name], [user_id], [total], [status]) VALUES (10, CAST(N'2024-07-07T15:23:57.440' AS DateTime), N'customer6', 0, 396000, 3)
INSERT [dbo].[Bill] ([bill_id], [bill_date], [customer_name], [user_id], [total], [status]) VALUES (11, CAST(N'2024-07-07T15:36:37.813' AS DateTime), N'nguyenmanhtung', 1, 232500, 3)
SET IDENTITY_INSERT [dbo].[Bill] OFF
GO
SET IDENTITY_INSERT [dbo].[BillDetails] ON 

INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (7, 2, 74100, 1, 5)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (8, 1, 79200, 3, 5)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (9, 6, 66300, 1, 6)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (10, 6, 66300, 1, 7)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (11, 2, 74100, 1, 8)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (12, 1, 79200, 1, 8)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (13, 1, 79200, 5, 10)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (14, 2, 74100, 1, 11)
INSERT [dbo].[BillDetails] ([id_bill_details], [book_id], [book_price], [amount], [bill_id]) VALUES (15, 1, 79200, 2, 11)
SET IDENTITY_INSERT [dbo].[BillDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Books] ON 

INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (1, N'999 Lá Thư Gửi Cho Chính Mình - Những Lá Thư Ấn Tượng Nhất (Phiên Bản Song Ngữ Trung - Việt)', N'https://cdn0.fahasa.com/media/catalog/product/8/9/8935325010736.jpg', 100, N'Miêu Công Tử', CAST(N'2024-07-05T00:00:00.000' AS DateTime), 125012, N'Thanh Niên', N'very good', 1, 1)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (2, N'Trốn Lên Mái Nhà Để Khóc - Tặng Kèm Bookmark', N'https://cdn0.fahasa.com/media/catalog/product/b/_/b_a-1-tr_n-l_n-m_i-nh_-_-kh_c-2.jpg', 100, N'Lam', CAST(N'2024-07-05T09:35:01.050' AS DateTime), 74100, N'Skybooks', NULL, 1, 1)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (3, N'Combo Sách Ghi Chép Pháp Y (Bộ 3 Cuốn)', N'https://cdn0.fahasa.com/media/catalog/product/0/5/055cd615-0716-4f98-9ca7-33aef03b4fad.jpg', 100, N'Hiểu Huy, Liêu Tiểu Đao', CAST(N'2024-07-05T09:35:01.050' AS DateTime), 288563, N'AZ Việt Nam', NULL, 1, 1)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (4, N'Sếp Ơi! Tại Sao Không Thăng Chức Cho Tôi?', N'https://cdn0.fahasa.com/media/catalog/product/i/m/image_180225.jpg', 100, N'Noboru Koyama', CAST(N'2024-07-05T09:35:01.050' AS DateTime), 39200, N'ZenBooks', NULL, 2, 1)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (5, N'Trò Chơi Tâm Lý (Tái Bản 2024)', N'https://cdn0.fahasa.com/media/catalog/product/t/r/tr_-ch_i-t_m-l_-b_a-1.jpg', 100, N'Eric Berne', CAST(N'2024-07-05T09:35:01.050' AS DateTime), 156750, N'1980 Books', NULL, 2, 1)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (6, N'Nghệ Thuật Đánh Bại Burnout', N'https://cdn0.fahasa.com/media/catalog/product/b/i/bia-1-ngh_-thu_t-_nh-b_i-burnout.jpg', 100, N'Tony Wrighton', CAST(N'2024-07-05T09:35:40.830' AS DateTime), 66300, N'Skybooks', NULL, 2, 1)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (7, N'123', N'img/Screenshot 2024-07-06 150240.png', 123, N'tungnmxinchao', NULL, 123000, N'tungnmxinchao', N'hello', 1, 0)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (8, N'booksec', N'img/432360966_122192626028091095_5863289487999889641_n.jpg', 123, N'tungnmxinchao', CAST(N'2024-07-09T00:00:00.000' AS DateTime), 1230000, N'tung', N'tungtung', 1, 0)
INSERT [dbo].[Books] ([book_id], [name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) VALUES (9, N'123', N'img/Screenshot 2024-07-06 150240.png', 123, N'123', CAST(N'2024-07-10T00:00:00.000' AS DateTime), 123, N'123123', N'123', 1, 0)
SET IDENTITY_INSERT [dbo].[Books] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([category_id], [name]) VALUES (1, N'Văn học')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (2, N'Tâm lý')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([user_id], [username], [password], [full_name], [rollNumber], [phone], [role], [status]) VALUES (1, N'tungnm', N'123', N'tung123', N'he1123456', N'0123456789', 2, 0)
INSERT [dbo].[Users] ([user_id], [username], [password], [full_name], [rollNumber], [phone], [role], [status]) VALUES (2, N'admin', N'123', N'admin', N'he123456', N'0123456789', 2, 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Bill] ADD  CONSTRAINT [DF_Bill_bill_date]  DEFAULT (getdate()) FOR [bill_date]
GO
ALTER TABLE [dbo].[Books] ADD  CONSTRAINT [DF_Books_date_of_public]  DEFAULT (getdate()) FOR [date_of_public]
GO
