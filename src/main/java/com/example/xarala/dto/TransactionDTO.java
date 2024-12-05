package com.example.xarala.dto;

import com.example.xarala.data.model.TransactionType;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private String id;
    private String description;
    private TransactionType type;
    private Double amount;
    private LocalDateTime date;
}