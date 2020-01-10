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
@Table(name = "Symbol_Directory")
public class MessageR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank
    @Size(max = 100)
    private String Length;

    @NotBlank
    @Size(max = 100)
    private String MessageType;

    @Nullable
    @Size(max = 100)
    private String MessageTypeString;

    @Nullable
    @Size(max = 100)
    private String HeaderId;

    @Nullable
    @Size(max = 100)
    private String Nanosecond;

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
    private String SymbolStatus;

    @Nullable
    @Size(max = 100)
    private String ISIN;

    @Nullable
    @Size(max = 100)
    private String Symbol;

    @Nullable
    @Size(max = 100)
    private String TIDM;

    @Nullable
    @Size(max = 100)
    private String Segment;

    @Nullable
    @Size(max = 100)
    private String PrevClosePrice;

    @Nullable
    @Size(max = 100)
    private String ExpirationDate;

    @Nullable
    @Size(max = 100)
    private String Underlying;

    @Nullable
    @Size(max = 100)
    private String StrikePrice;

    @Nullable
    @Size(max = 100)
    private String OptionType;

    @Nullable
    @Size(max = 100)
    private String Issuer;

    @Nullable
    @Size(max = 100)
    private String IssueDate;

    @Nullable
    @Size(max = 100)
    private String Coupon;

    @Nullable
    @Size(max = 100)
    private String Flags;

    @Nullable
    @Size(max = 100)
    private String SubBook;

    @Nullable
    @Size(max = 100)
    private String CorporateAction;
}
