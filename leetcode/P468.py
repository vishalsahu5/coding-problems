class Solution(object):
    
    def validateIPV4(self, segments):
        for segment in segments:
            try:
                if (len(segment) > 3) or (int(segment, 10) > 255) or (int(segment, 10) < 0) or segment == '000' or segment == '00' or (len(segment) > 1 and int(segment[0]) == 0):
                    return False
            except ValueError:
                return False
        return True
    
    def validateIPV6(self, segments):
        for segment in segments:
            try:
                if len(segment) > 4:
                    return False        
                if int(segment, 16) < 0:
                    return False
            except ValueError:
                return False
        return True
    
    def validIPAddress(self, IP):
        """
        :type IP: str
        :rtype: str
        """
        if len(IP) > 39 or '-' in IP:
            return "Neither"
        segments = None
        if '.' in IP:
            segments = IP.strip().split('.')
        elif ':' in IP:
            segments = IP.strip().split(':')
        else:
            return "Neither"
        if len(segments) == 4 and self.validateIPV4(segments):
            return "IPv4"
        elif len(segments) == 8 and self.validateIPV6(segments):
            return "IPv6"
        else:
            return "Neither"
        