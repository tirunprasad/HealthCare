  $(document).ready(function(){
               
                $("#specCodeError").hide();
                $("#specNameError").hide();
                $("#specNoteError").hide();

                var specCodeError = false;
                var specNameError = false;
                var specNoteError = false;

                function validate_specCode(){
                    var val = $("#specCode").val();
                    var exp = /^[A-Z]{4,10}$/;
                    if(val==''){
                        $("#specCodeError").show();
                        specCodeError = false;
                        $("#specCodeError").html("<b>Code</B> can not be empty");
                    }
                    else if(!exp.test(val)){
                        $("#specCodeError").show();
                        specCodeError = false; 
                        $("#specCodeError").html("<b>Code</B> must be 4 to 10 chars");
                    }
                    else {
                        $("#specCodeError").hide();
                         specCodeError = true;
                    }
                    return specCodeError;
                }
                function validate_specName(){
                    var val = $("#specName").val();
                    var exp = /^[A-Za-z\s]{4,25}$/
                    if(val==''){
                        $("#specNameError").show();
                        specNameError = false;
                        $("#specNameError").html("<b>Name</b> can not be empty");
                    }
                    else if(!exp.test(val)){
                        $("#specNameError").show();
                        specNameError = false; 
                        $("#specNameError").html("Only must be 4-25 char and space allowed ");
                    }
                    else{
                        $("#specNameError").hide();
                        specNameError = true;
                    }
                    return specNameError;
                }

                function validate_specNote(){
                    var val = $("#specNote").val();
                    var exp = /^[A-Za-z\s\.\,]{4,50}$/
                    if(val==''){
                        $("#specNoteError").show();
                        specNoteError = false;
                        $("#specNoteError").html("<b>Note</b> can not be empty");
                    }
                    else if(!exp.test(val)){
                        $("#specNoteError").show();
                        specNoteError = false; 
                        $("#specNoteError").html("Only must be 4-50 char and ( space , . ) symbols are allowed ");
                    }
                    else{
                        $("#specNoteError").hide();
                        specNoteError = true;
                    }
                    return specNoteError;
                }
                

                $("#specCode").keyup(function(){
                    $(this).val($(this).val().toUpperCase());
                    validate_specCode();
                   
                })
                $("#specName").keyup(function(){
                    validate_specName();
                   
                })
                $("#specNote").keyup(function(){
                    validate_specNote();
                   
                })


                $("#specForm").submit(function(){
                    validate_specCode();
                    validate_specName();
                    validate_specNote();

                    if(specCodeError && specNameError && specNoteError) return true;
                    else return false;
                })


            })