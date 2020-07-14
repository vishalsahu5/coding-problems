class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        # 6 hours = 180 deg => 1 hour = 30 deg , 1 min = 0.5 deg
        # 60 minutes = 360 deg => 1 minute = 6 deg
        hourDeg = 30.00000
        minDeg = 6.00000

        minutes = float(minutes % 60)
        hour = float(hour % 12)

        hAngle = float((hour * hourDeg) + (minutes * 0.50000))
        mAngle = float(minutes * minDeg)
        diff = abs(hAngle - mAngle)
        return diff if diff < 180.00000 else float(360.00000 - diff)
