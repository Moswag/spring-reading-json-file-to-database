package zw.co.cytex.readjson.readjson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Symbol_Status")
public class MessageA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String Length;

    @NotBlank
    @Size(max = 15)
    private String MessageType;

    @Nullable
    @Size(max = 100)
    private String Nanosecond;

    @Nullable
    @Size(max = 100)
    private String OrderID;

    @Nullable
    @Size(max = 100)
    private String Side;

    @Nullable
    @Size(max = 100)
    private String Quantity;

    @Nullable
    @Size(max = 100)
    private String InstrumentID;

    @Nullable
    @Size(max = 100)
    private String Reserved1;

    @Nullable
    @Size(max = 100)
    private String Reserved2;

    @Nullable
    @Size(max = 100)
    private String Price;

    @Nullable
    @Size(max = 100)
    private String Flags;

    @Nullable
    @Size(max = 100)
    private String HeaderId;

    @Nullable
    @Size(max = 100)
    private String MessageTypeString;

}
